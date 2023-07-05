;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Print)
(use PolyPath)
(use Feature)
(use Motion)
(use System)

(class View of Feature
	(properties
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal 257
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal 0
		scaleX 128
		scaleY 128
		maxScale 128
	)

	(method (init &tmp temp0)
		(= temp0 (if (& signal $0020) gAddToPics else gCast))
		(&= signal $7fff)
		(if (not (temp0 contains: self))
			(= lsRight (= lsBottom (= lsLeft (= lsTop 0))))
			(&= signal $ff77)
		)
		(BaseSetter self)
		(temp0 add: self)
		(if (== temp0 gAddToPics)
			(if (not (& signal $0010))
				(= priority (CoordPri y))
			)
			(SetNowSeen self)
			(temp0 doit:)
		)
		(self initialize: checkDetail:)
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
		(BaseSetter self)
		(self forceUpd:)
	)

	(method (dispose)
		(self startUpd: hide:)
		(|= signal $8000)
	)

	(method (hide)
		(|= signal $0008)
	)

	(method (show)
		(&= signal $fff7)
	)

	(method (delete)
		(if (& signal $8000)
			(&= signal $7fff)
			(cond
				((gAddToPics contains: self)
					(gAddToPics delete: self)
					(&= signal $ffdf)
				)
				((& signal $0020)
					(gCast delete: self)
					(gAddToPics add: self)
					(return)
				)
				(else
					(gCast delete: self)
				)
			)
			(if underBits
				(UnLoad 133 underBits)
				(= underBits 0)
			)
			(super dispose:)
			(if (IsObject actions)
				(actions dispose:)
			)
			(= actions 0)
		)
	)

	(method (stopUpd)
		(|= signal $0001)
		(&= signal $fffd)
	)

	(method (forceUpd)
		(|= signal $0040)
	)

	(method (startUpd)
		(|= signal $0002)
		(&= signal $fffe)
	)

	(method (setPri newPri)
		(cond
			((== argc 0)
				(|= signal $0010)
			)
			((== newPri -1)
				(&= signal $ffef)
			)
			(else
				(= priority newPri)
				(|= signal $0010)
			)
		)
		(self forceUpd:)
	)

	(method (setLoop newLoop)
		(cond
			((== argc 0)
				(|= signal $0800)
			)
			((== newLoop -1)
				(&= signal $f7ff)
			)
			(else
				(= loop newLoop)
				(|= signal $0800)
			)
		)
		(self forceUpd:)
	)

	(method (setCel newCel)
		(cond
			((== argc 0) 0)
			((== newCel -1) 0)
			(else
				(= cel
					(if (>= newCel (self lastCel:))
						(self lastCel:)
					else
						newCel
					)
				)
			)
		)
		(self forceUpd:)
	)

	(method (ignoreActors arg)
		(if (or (== 0 argc) arg)
			(|= signal $4000)
		else
			(&= signal $bfff)
		)
	)

	(method (addToPic)
		(if (gCast contains: self)
			(|= signal $8021)
		else
			(|= signal $0020)
			(self init:)
		)
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (showSelf)
		(Print addText: name addIcon: view loop cel init:)
	)

	(method (motionCue))

	(method (checkDetail))

	(method (isNotHidden)
		(return (not (& signal $0088)))
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (IsObject theObjOrX)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return
			(cond
				((& signal $0080) 0)
				((and (not (IsObject onMeCheck)) (& signal $1000))
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft oX nsRight)
								(<= nsTop oY nsBottom)
							)
						)
						(not
							(IsItSkip
								view
								loop
								cel
								(- oY nsTop)
								(- oX nsLeft)
							)
						)
					)
				)
				(else
					(super onMe: oX oY)
				)
			)
		)
	)

	(method (setScale theY &tmp deltaY1 deltaY2 pctInc [str 40])
		(cond
			((not argc)
				(|= scaleSignal $0001)
				(&= scaleSignal $fffd)
			)
			((not theY)
				(&= scaleSignal $fffc)
			)
			((< theY (gCurRoom vanishingY:))
				(Printf {<%s setScale:> y value less than vanishingY} name)
			)
			(else
				(= deltaY1 (- theY (gCurRoom vanishingY:)))
				(= pctInc (+ (/ (* (= deltaY2 (- 190 theY)) 100) deltaY1) 100))
				(|= scaleSignal $0003)
				(= maxScale (/ (* pctInc 128) 100))
			)
		)
	)
)

(class Prop of View
	(properties
		signal 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
	)

	(method (doit &tmp aState)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if cycler
			(cycler doit:)
		)
		(if scaler
			(scaler doit:)
		)
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
			(self startUpd:)
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

	(method (delete)
		(if (& signal $8000)
			(self setScript: 0 setCycle: 0)
			(if timer
				(timer dispose:)
			)
			(if (IsObject scaler)
				(scaler dispose:)
				(= scaler 0)
			)
			(super delete:)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (setScript newScript)
		(if (IsObject script)
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
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)

	(method (setScale theObjOrMatchOrY whoToMatch)
		(if scaler
			(scaler dispose:)
			(= scaler 0)
		)
		(cond
			((not argc)
				(super setScale:)
			)
			((IsObject theObjOrMatchOrY)
				(|= scaleSignal $0001)
				(&= scaleSignal $fffd)
				(= scaler
					(if (& (theObjOrMatchOrY -info-:) $8000)
						(theObjOrMatchOrY new:)
					else
						theObjOrMatchOrY
					)
				)
				(scaler init: self whoToMatch &rest)
			)
			((== theObjOrMatchOrY -1)
				(if (whoToMatch scaleSignal:)
					(= scaleSignal (whoToMatch scaleSignal:))
					(= maxScale (whoToMatch maxScale:))
					(if (IsObject (whoToMatch scaler:))
						((= scaler ((whoToMatch scaler:) new:)) client: self)
					)
				)
			)
			(else
				(super setScale: theObjOrMatchOrY)
			)
		)
	)
)

(class Actor of Prop
	(properties
		illegalBits -32768
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
	)

	(method (init)
		(super init: &rest)
		(= xLast x)
		(= yLast y)
	)

	(method (doit &tmp aState left right txStep tyStep oldXStep oldYStep stepVal)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if viewer
			(viewer doit: self)
		)
		(if avoider
			(avoider doit:)
		)
		(if mover
			(if (and (& scaleSignal $0001) (not (& scaleSignal $0004)))
				(= oldXStep (>> origStep $0008))
				(= oldYStep (& origStep $00ff))
				(= txStep (if (= stepVal (/ (* oldXStep scaleX) 128)) stepVal else 1))
				(= tyStep (if (= stepVal (/ (* oldYStep scaleY) 128)) stepVal else 1))
				(if (or (!= txStep xStep) (!= tyStep yStep))
					(self setStep: txStep tyStep 1)
				)
			)
			(if mover
				(mover doit:)
			)
		)
		(if scaler
			(scaler doit:)
		)
		(if cycler
			(= left brLeft)
			(= right brRight)
			(cycler doit:)
			(if baseSetter
				(baseSetter doit: self)
			else
				(BaseSetter self)
			)
		)
		(= xLast x)
		(= yLast y)
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
			(self startUpd:)
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
			(if (and (IsObject aType) (& (aType -info-:) $8000))
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
			(or
				(not (IsObject mover))
				(and (== x (mover xLast:)) (== y (mover yLast:)))
			)
		)
	)

	(method (isBlocked)
		(return (& signal $0400))
	)

	(method (delete)
		(if (& signal $8000)
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
			(if (IsObject actions)
				(actions dispose:)
				(= actions 0)
			)
			(super delete:)
		)
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
		(if baseSetter
			(baseSetter doit: self)
		else
			(BaseSetter self)
		)
		(= ret
			(cond
				((CantBeHere self (gCast elements:)))
				(
					(and
						(not (& signal $2000))
						(IsObject gCurRoom)
						(< y (gCurRoom horizon:))
					)
					-1
				)
				((and blocks (not (blocks allTrue: 57 self))) -2)
			)
		)
	)

	(method (inRect lx uy rx by)
		(return (and (<= lx x) (<= x rx) (<= uy y) (<= y by)))
	)

	(method (onControl org)
		(if (and argc org)
			(OnControl CONTROL x y)
		else
			(OnControl CONTROL brLeft brTop brRight brBottom)
		)
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
				(IsObject mover)
				(or (mover isMemberOf: MoveTo) (mover isMemberOf: PolyPath))
			)
			(mover init:)
		)
	)

	(method (setDirection dir &tmp vx vy xIncr yIncr ang maxCoord pathPts obs)
		(= vx
			(if (== (= vy (gCurRoom vanishingY:)) -30000)
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
			(= pathPts
				(AvoidPath
					x
					y
					(+ x xIncr)
					(+ y yIncr)
					(obs elements:)
					(obs size:)
					0
				)
			)
			(= xIncr (- (WordAt pathPts 2) x))
			(= yIncr (- (WordAt pathPts 3) y))
			(Memory memFREE pathPts)
		)
		(cond
			((or xIncr yIncr)
				(self setMotion: MoveTo (+ x xIncr) (+ y yIncr))
			)
			(dir
				(self setMotion: 0 setHeading: (* (- dir 1) 45))
			)
			(else
				(self setMotion: 0)
			)
		)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(super motionCue:)
	)

	(method (setLoop l &tmp newLooper)
		(if
			(= newLooper
				(cond
					((== argc 0)
						(super setLoop:)
						0
					)
					((not (IsObject l))
						(super setLoop: l &rest)
						0
					)
					((& (l -info-:) $8000)
						(l new:)
					)
					(else l)
				)
			)
			(if looper
				(looper dispose:)
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
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			((or cycler mover)
				(self startUpd:)
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
			(if (and (>= argc 2) (IsObject whoCares))
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
)

