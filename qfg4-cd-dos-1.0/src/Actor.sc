;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64998)
(include sci.sh)
(use Main)
(use Array)
(use Print)
(use Scaler)
(use PolyPath)
(use Feature)
(use Motion)
(use System)

(class View of Feature
	(properties
		scaleX 128
		scaleY 128
		maxScale 128
		scaleType 0
		priority 0
		fixPriority 0
		inLeft 0
		inTop 0
		inRight 0
		inBottom 0
		useInsetRect 0
		view -1
		loop 0
		cel 0
		bitmap 0
		yStep 2
		signal 16417
		lsLeft 0
		lsTop 0
		lsRight 0
		lsBottom 0
		brLeft 0
		brTop 0
		brRight 0
		brBottom 0
		scaleSignal 0
		magnifier 0
		oldScaleX 128
	)

	(method (init param1 &tmp temp0)
		(= temp0 (if argc param1 else gCast))
		(&= signal $fff7)
		(temp0 add: self)
		(= plane (temp0 plane:))
		(AddScreenItem self)
		(|= -info- $0010)
		(if (not (temp0 contains: self))
			(= lsBottom (= lsRight (= lsTop (= lsLeft 0))))
			(&= signal $fff7)
		)
		(= useInsetRect 0)
		(if (and (== view -1) bitmap)
			(&= signal $ffdf)
		)
		(if (& signal $0020)
			(BaseSetter self)
		)
		(if (!= view -1)
			(SetNowSeen self)
		)
		(self initialize: checkDetail:)
	)

	(method (doit)
		(if (and (& -info- $0008) (self isNotHidden:))
			(UpdateScreenItem self)
		)
	)

	(method (posn newX newY newZ)
		(if (>= argc 1)
			(= x newX)
			(if (>= argc 2)
				(= y newY)
				(if (>= argc 3)
					(= z newZ)
				)
			)
		)
		(if (& signal $0020)
			(BaseSetter self)
		)
	)

	(method (hide)
		(if (self isNotHidden:)
			(|= signal $0008)
			(DeleteScreenItem self)
			(&= -info- $ffef)
		)
	)

	(method (show)
		(if (not (self isNotHidden:))
			(&= signal $fff7)
			(AddScreenItem self)
			(|= -info- $0010)
		)
	)

	(method (dispose &tmp theSet)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
			(&= -info- $ffef)
		)
		(if plane
			(= theSet (plane casts:))
			(theSet eachElementDo: #delete self)
			(= plane 0)
		)
		(super dispose:)
	)

	(method (setPri newPri)
		(cond
			((== argc 0)
				(= fixPriority 1)
			)
			((== newPri -1)
				(= fixPriority 0)
			)
			(else
				(= priority newPri)
				(= fixPriority 1)
			)
		)
	)

	(method (setLoop newLoop fixIt)
		(cond
			((== argc 0)
				(|= signal $0800)
			)
			((== newLoop -1)
				(&= signal $f7ff)
			)
			(else
				(= loop newLoop)
				(if (> argc 1)
					(if fixIt
						(|= signal $0800)
					else
						(&= signal $f7ff)
					)
				)
			)
		)
	)

	(method (setCel newCel)
		(= cel newCel)
	)

	(method (setInsetRect l t r b)
		(if (< argc 4)
			(= useInsetRect 0)
			(= inLeft nsLeft)
			(= inTop nsTop)
			(= inRight nsRight)
			(= inBottom nsBottom)
		else
			(= useInsetRect 1)
			(= inLeft l)
			(= inTop t)
			(= inRight r)
			(= inBottom b)
		)
	)

	(method (ignoreActors arg)
		(if (or (== 0 argc) arg)
			(|= signal $4000)
		else
			(&= signal $bfff)
		)
	)

	(method (lastLoop)
		(return (- (NumLoops self) 1))
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (motionCue))

	(method (checkDetail))

	(method (isNotHidden)
		(return (not (& signal $0008)))
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (== argc 1)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return
			(cond
				((& signal $0008) 0)
				((not onMeCheck)
					(OnMe oX oY self (& signal $1000))
				)
				(else
					(super onMe: oX oY)
				)
			)
		)
	)

	(method (setScale theYorW theH &tmp deltaY1 deltaY2 pctInc w h)
		(cond
			((not argc)
				(|= scaleSignal $0001)
				(&= scaleSignal $fffd)
			)
			((== argc 2)
				(= w (CelWide view loop cel))
				(= h (CelHigh view loop cel))
				(if (== theYorW -1)
					(= theYorW w)
				)
				(if (== theH -1)
					(= theH h)
				)
				(= scaleX (/ (* theYorW 128) w))
				(= scaleY (/ (* theH 128) h))
				(|= scaleSignal $0001)
				(UpdateScreenItem self)
			)
			((not theYorW)
				(&= scaleSignal $fffc)
			)
			((< theYorW (gCurRoom vanishingY:))
				(Printf {<%s setScale:> y value less than vanishingY} name)
			)
			(else
				(= deltaY1 (- theYorW (gCurRoom vanishingY:)))
				(= pctInc (+ (/ (* (= deltaY2 (- 190 theYorW)) 100) deltaY1) 100))
				(|= scaleSignal $0003)
				(= maxScale (/ (* pctInc 128) 100))
			)
		)
	)

	(method (setMagnifier theMag)
		(if (not (& signal $0008))
			(if magnifier
				(magnifier dispose:)
			)
			(if (and argc theMag)
				((= magnifier theMag) init: self &rest)
			)
		)
	)
)

(class Prop of View
	(properties
		signal 33
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
	)

	(method (setLoop &tmp oLoop)
		(= oLoop loop)
		(super setLoop: &rest)
		(if (and cycler (!= oLoop loop))
			(cycler clientLastCel: (self lastCel:))
		)
	)

	(method (doit &tmp aState)
		(if script
			(script doit:)
		)
		(if (& signal $0001)
			(if cycler
				(cycler doit:)
			)
			(if scaler
				(scaler doit:)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
		(super handleEvent: event)
	)

	(method (setCycle cType)
		(if cycler
			(cycler dispose:)
		)
		(if cType
			(= cycler
				(if (& (cType -info-:) $8000)
					(cType new:)
				else
					cType
				)
			)
			(cycler init: self &rest)
		else
			(= cycler 0)
		)
	)

	(method (dispose)
		(self setScript: 0 setCycle: 0)
		(if timer
			(timer dispose:)
		)
		(if scaler
			(scaler dispose:)
			(= scaler 0)
		)
		(super dispose:)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (motionCue)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)

	(method (checkDetail theLevel)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						theLevel
					else
						(gGlory detailLevel:)
					)
					detailLevel
				)
				(&= signal $fffe)
			)
			(else
				(|= signal $0001)
			)
		)
	)

	(method (setScaler theScaler)
		(if scaler
			(scaler dispose:)
			(= scaler 0)
		)
		(cond
			((or (not argc) (not theScaler))
				(return)
			)
			((theScaler isKindOf: Scaler)
				(= scaler
					(if (& (theScaler -info-:) $8000)
						(theScaler new:)
					else
						theScaler
					)
				)
				(|= scaleSignal $0001)
				(&= scaleSignal $fffd)
				(scaler init: self &rest)
			)
			(else
				(= scaler ((theScaler scaler:) new:))
				(= scaleSignal (theScaler scaleSignal:))
				(= maxScale (theScaler maxScale:))
				(scaler client: self doit:)
			)
		)
	)

	(method (setScale theObjOrY)
		(if scaler
			(scaler dispose:)
			(= scaler 0)
		)
		(if (not argc)
			(super setScale:)
		else
			(super setScale: theObjOrY)
		)
	)
)

(class Actor of Prop
	(properties
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		origStep 770
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		robot 0
	)

	(method (init)
		(super init: &rest)
		(= xLast x)
		(= yLast y)
	)

	(method (doit &tmp [temp0 2] temp2 temp3 temp4)
		(if robot
			(robot doit:)
		)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (& signal $0001)
			(if viewer
				(viewer doit: self)
			)
			(if avoider
				(avoider doit:)
			)
			(if mover
				(mover doit:)
			)
			(if cycler
				(cycler doit:)
			)
			(if (& -info- $0008)
				(if scaler
					(scaler doit:)
				)
				(= xLast x)
				(= yLast y)
				(if (self isNotHidden:)
					(UpdateScreenItem self)
				)
				(if
					(and
						(& scaleSignal $0001)
						(not (& scaleSignal $0004))
						(!= scaleX oldScaleX)
					)
					(= oldScaleX scaleX)
					(= temp2
						(if
							(= temp4
								(>> (+ (* (>> origStep $0008) scaleX) 64) $0007)
							)
							temp4
						else
							1
						)
					)
					(= temp3
						(if
							(= temp4
								(>> (+ (* (& origStep $00ff) scaleY) 64) $0007)
							)
							temp4
						else
							1
						)
					)
					(if (or (!= temp2 xStep) (!= temp3 yStep))
						(self setStep: temp2 temp3 1)
					)
				)
				(cond
					((not (& signal $0020)))
					(baseSetter
						(baseSetter doit: self)
					)
					(else
						(BaseSetter self)
					)
				)
			)
		)
	)

	(method (posn newX newY)
		(super posn: newX newY &rest)
		(= xLast newX)
		(= yLast newY)
	)

	(method (setMotion mType)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if mType
			(= mover
				(if (& (mType -info-:) $8000)
					(mType new:)
				else
					mType
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
		)
	)

	(method (setAvoider aType)
		(if avoider
			(avoider dispose:)
		)
		(= avoider
			(if (and aType (& (aType -info-:) $8000))
				(aType new:)
			else
				aType
			)
		)
		(if avoider
			(avoider init: self &rest)
		)
	)

	(method (isStopped)
		(return
			(or (not mover) (and (== x (mover xLast:)) (== y (mover yLast:))))
		)
	)

	(method (isBlocked)
		(return (& signal $0400))
	)

	(method (dispose)
		(if robot
			(self setRobot:)
		)
		(if (!= mover -1)
			(self setMotion: 0)
		)
		(self setAvoider: 0)
		(if baseSetter
			(baseSetter dispose:)
			(= baseSetter 0)
		)
		(if looper
			(looper dispose:)
			(= looper 0)
		)
		(if viewer
			(viewer dispose:)
			(= viewer 0)
		)
		(if blocks
			(blocks dispose:)
			(= blocks 0)
		)
		(if code
			(code dispose:)
			(= code 0)
		)
		(super dispose:)
	)

	(method (ignoreHorizon arg)
		(if (or (not argc) arg)
			(|= signal $2000)
		else
			(&= signal $dfff)
		)
	)

	(method (observeControl ctrl &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			(|= illegalBits [ctrl i])
		)
	)

	(method (ignoreControl ctrl &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			(&= illegalBits (~ [ctrl i]))
		)
	)

	(method (observeBlocks)
		(if (not blocks)
			(= blocks (Set new:))
		)
		(blocks add: &rest)
	)

	(method (ignoreBlocks)
		(if blocks
			(blocks delete: &rest)
			(if (blocks isEmpty:)
				(blocks dispose:)
				(= blocks 0)
			)
		)
	)

	(method (distanceTo anObj)
		(GetDistance x y (anObj x:) (anObj y:) gPerspective)
	)

	(method (cantBeHere &tmp ret)
		(cond
			((not (& signal $0020)))
			(baseSetter
				(baseSetter doit: self)
			)
			(else
				(BaseSetter self)
			)
		)
		(= ret
			(cond
				((CantBeHere self (gCast elements:)))
				((and (not (& signal $2000)) gCurRoom (< y (gCurRoom horizon:))) -1)
				((and blocks (not (blocks allTrue: #doit self))) -2)
			)
		)
	)

	(method (inRect lx uy rx by)
		(return (and (<= lx x) (<= x rx) (<= uy y) (<= y by)))
	)

	(method (setStep xs ys leaveOriginal &tmp theX theY)
		(= theX (>> origStep $0008))
		(= theY (& origStep $00ff))
		(if (and (>= argc 1) (!= xs -1))
			(= theX xs)
		)
		(if (and (>= argc 2) (!= ys -1))
			(= theY ys)
		)
		(if (or (< argc 3) (not leaveOriginal))
			(= origStep (+ (<< theX $0008) theY))
		)
		(= xStep theX)
		(= yStep theY)
		(if
			(and
				mover
				(or (mover isMemberOf: MoveTo) (mover isMemberOf: PolyPath))
			)
			(mover init:)
		)
	)

	(method (setDirection dir &tmp vx vy xIncr yIncr ang maxCoord pathPts obs xNode yNode planeW planeH)
		(= vx
			(if (== (= vy (gCurRoom vanishingY:)) 35536)
				x
			else
				(gCurRoom vanishingX:)
			)
		)
		(if (and (== xStep 0) (== yStep 0))
			(return)
		)
		(= maxCoord (/ 32000 (Max xStep yStep)))
		(switch dir
			(0
				(self setMotion: 0)
				(return)
			)
			(1
				(= xIncr (- vx x))
				(= yIncr (- vy y))
			)
			(5
				(= xIncr (- x vx))
				(= yIncr (- y vy))
			)
			(3
				(= xIncr maxCoord)
				(= yIncr 0)
			)
			(7
				(= xIncr (- maxCoord))
				(= yIncr 0)
			)
			(else
				(if (< 180 (= ang (GetAngle x y vx vy)))
					(-= ang 360)
				)
				(= ang (+ (/ (+ ang 90) 2) (* 45 (- dir 2))))
				(= xIncr (SinMult ang 100))
				(= yIncr (- (CosMult ang 100)))
			)
		)
		(/= maxCoord 5)
		(while (and (< (Abs yIncr) maxCoord) (< (Abs xIncr) maxCoord))
			(*= xIncr 5)
			(*= yIncr 5)
		)
		(if (and (= obs (gCurRoom obstacles:)) gUseObstacles)
			(= pathPts (IntArray new:))
			(= planeW (+ (- (plane right:) (plane left:)) 1))
			(= planeH (+ (- (plane bottom:) (plane top:)) 1))
			(pathPts
				copy:
					(AvoidPath
						x
						y
						(+ x xIncr)
						(+ y yIncr)
						obs
						planeW
						planeH
						0
					)
			)
			(= xNode (pathPts at: 2))
			(= yNode (pathPts at: 3))
			(= xIncr (- xNode x))
			(= yIncr (- yNode y))
			(if gAltPolyList
				(pathPts
					copy: (AvoidPath x y xNode yNode gAltPolyList planeW planeH 0)
				)
				(if
					(or
						(!= (pathPts at: 2) (+ x xIncr))
						(!= (pathPts at: 3) (+ y yIncr))
					)
					(= xIncr (- (pathPts at: 2) x))
					(= yIncr (- (pathPts at: 3) y))
				)
			)
			(pathPts dispose:)
		)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(super motionCue:)
	)

	(method (setLooper theLooper &tmp newLooper)
		(if looper
			(looper dispose:)
		)
		(if (and argc theLooper)
			(= newLooper
				(if (& (theLooper -info-:) $8000)
					(theLooper new:)
				else
					theLooper
				)
			)
			((= looper newLooper) init: self &rest)
		)
	)

	(method (checkDetail theLevel)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						theLevel
					else
						(gGlory detailLevel:)
					)
					detailLevel
				)
				(&= signal $fffe)
			)
			(else
				(|= signal $0001)
			)
		)
	)

	(method (setHeading h whoCares)
		(if argc
			(= heading h)
		)
		(if looper
			(looper doit: self heading (and (>= argc 2) whoCares))
		else
			(DirLoop self heading)
			(if cycler
				(cycler clientLastCel: (self lastCel:))
			)
			(if (and (>= argc 2) whoCares)
				(whoCares cue: &rest)
			)
		)
		(return heading)
	)

	(method (setSpeed theSpeed)
		(if argc
			(= moveSpeed (= cycleSpeed theSpeed))
		)
		(return moveSpeed)
	)

	(method (setRobot walkie passSelf &tmp ps)
		(cond
			((and argc walkie)
				(= robot
					(if (& (walkie -info-:) $8000)
						(walkie new:)
					else
						walkie
					)
				)
				(= ps (if (and (> argc 1) passSelf) self else 0))
				(robot init: ps &rest)
			)
			(robot
				(robot dispose: argc)
				(= robot 0)
			)
		)
	)
)

