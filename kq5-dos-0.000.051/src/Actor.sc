;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Motion)
(use System)

(class MyLooper of Code
	(properties)

	(method (doit param1 param2)
		(proc0_25 param1 param2)
	)
)

(class Feature of Obj
	(properties
		y 0
		x 0
		z 0
		heading 0
	)

	(method (dispose)
		(gFeatures delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(event claimed:)
	)
)

(class PV of Feature
	(properties
		view 0
		loop 0
		cel 0
		priority -1
		signal 0
	)

	(method (showSelf)
		(Print name #icon view loop cel)
	)
)

(class View of Feature
	(properties
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal 257
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
	)

	(method (init)
		(&= signal $7fff)
		(if (not (gCast contains: self))
			(= lsRight (= lsBottom (= lsLeft (= lsTop 0))))
			(&= signal $ff77)
		)
		(BaseSetter self)
		(gCast add: self)
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
			(if (& signal $0020)
				(gAddToPics
					add:
						((PV new:)
							view: view
							loop: loop
							cel: cel
							x: x
							y: y
							z: z
							priority: priority
							signal: signal
							yourself:
						)
				)
			)
			(&= signal $7fff)
			(gCast delete: self)
			(if underBits
				(UnLoad 133 underBits)
				(= underBits 0)
			)
			(super dispose:)
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
			((== argc 0)
				(|= signal $1000)
			)
			((== newCel -1)
				(&= signal $efff)
			)
			(else
				(|= signal $1000)
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
		(if (not (gCast contains: self))
			(self init:)
		)
		(self signal: (| signal $8021))
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (showSelf)
		(Print name #icon view loop cel)
	)

	(method (isExtra value &tmp ret)
		(= ret (& signal $0200))
		(if argc
			(if value
				(|= signal $0200)
			else
				(&= signal $fdff)
			)
		)
		(return ret)
	)

	(method (motionCue))
)

(class Prop of View
	(properties
		signal 0
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
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
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
		(event claimed:)
	)

	(method (setCycle cType)
		(if cycler
			(cycler dispose:)
		)
		(if cType
			(self startUpd:)
			(= cycler (cType new:))
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
		(if (= script newScript)
			(script init: self &rest)
		)
	)

	(method (motionCue)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)
)

(class Act of Prop
	(properties
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 0
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		btRange 10
		offset 0
	)

	(method (init)
		(super init:)
		(= xLast x)
		(= yLast y)
	)

	(method (doit &tmp aState left right)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(&= signal $fbff)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if viewer
			(viewer doit: self)
		)
		(cond
			(avoider
				(avoider doit:)
			)
			(mover
				(mover doit:)
			)
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
			(if
				(and
					(or (!= left brLeft) (!= right brRight))
					(not (self canBeHere:))
				)
				(self findPosn:)
			)
		)
		(= xLast x)
		(= yLast y)
	)

	(method (posn newX newY)
		(super posn: newX newY &rest)
		(= xLast newX)
		(= yLast newY)
		(if (not (self canBeHere:))
			(self findPosn:)
		)
	)

	(method (setMotion mType &tmp [str 40])
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
				(and (== x xLast) (== y yLast) (== (mover b-moveCnt:) 0))
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
		(blocks delete: &rest)
		(if (blocks isEmpty:)
			(blocks dispose:)
			(= blocks 0)
		)
	)

	(method (distanceTo anObj)
		(GetDistance x y (anObj x:) (anObj y:) gPerspective)
	)

	(method (canBeHere)
		(if baseSetter
			(baseSetter doit: self)
		else
			(BaseSetter self)
		)
		(return
			(and
				(CanBeHere self (gCast elements:))
				(or
					(& signal $2000)
					(not (IsObject gCurRoom))
					(>= y (gCurRoom horizon:))
				)
				(or (== blocks 0) (blocks allTrue: #doit self))
			)
		)
	)

	(method (findPosn &tmp legDir legLen xOrg yOrg goodPosn)
		(= xOrg x)
		(= yOrg y)
		(= goodPosn 0)
		(for ((= legLen 1)) (not goodPosn) ((++ legLen))
			(for ((= legDir 0)) (and (not goodPosn) (< legDir 8)) ((++ legDir))
				(= x (+ xOrg (* legLen (sign (CosMult (* legDir 45) 100)))))
				(= y (- yOrg (* legLen (sign (SinMult (* legDir 45) 100)))))
				(= goodPosn
					(if (self canBeHere:)
						(self onControl:)
					)
				)
			)
		)
		(self posn: x y)
	)

	(method (inRect lx uy rx by)
		(return (and (<= lx x) (< x rx) (<= uy y) (< y by)))
	)

	(method (onControl org)
		(if (and argc org)
			(OnControl CONTROL x y)
		else
			(OnControl CONTROL brLeft brTop brRight brBottom)
		)
	)

	(method (setStep xs ys)
		(if (and (>= argc 1) (!= xs -1))
			(= xStep xs)
		)
		(if (and (>= argc 2) (!= ys -1))
			(= yStep ys)
		)
		(if (and mover (!= -1 mover) (mover isMemberOf: MoveTo))
			(self setMotion: MoveTo (mover x:) (mover y:) (mover client:))
		)
	)

	(method (setDirection dir &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0
			(if (== (= temp1 (gCurRoom vanishingY:)) -30000)
				x
			else
				(gCurRoom vanishingX:)
			)
		)
		(if (and (== xStep 0) (== yStep 0))
			(return)
		)
		(= temp5 (/ 32000 (Min xStep yStep)))
		(switch dir
			(0
				(self setMotion: 0)
				(return)
			)
			(1
				(= temp2 (- temp0 x))
				(= temp3 (- temp1 y))
			)
			(5
				(= temp2 (- x temp0))
				(= temp3 (- y temp1))
			)
			(3
				(= temp2 temp5)
				(= temp3 0)
			)
			(7
				(= temp2 (- temp5))
				(= temp3 0)
			)
			(else
				(if (< 180 (= temp4 (GetAngle x y temp0 temp1)))
					(-= temp4 360)
				)
				(= temp4 (+ (/ (+ temp4 90) 2) (* 45 (- dir 2))))
				(= temp2 (SinMult temp4 100))
				(= temp3 (- (CosMult temp4 100)))
			)
		)
		(/= temp5 5)
		(while (and (< (Abs temp3) temp5) (< (Abs temp2) temp5))
			(*= temp2 5)
			(*= temp3 5)
		)
		(cond
			((and (= temp7 (gCurRoom obstacles:)) (or temp2 temp3))
				(if global72
					(self setMotion: PolyPath (+ x temp2) (+ y temp3))
				else
					(= temp6
						(AvoidPath
							x
							y
							(+ x temp2)
							(+ y temp3)
							(temp7 elements:)
							(temp7 size:)
							0
						)
					)
					(= temp2 (- (WordAt temp6 2) x))
					(= temp3 (- (WordAt temp6 3) y))
					(Memory memFREE temp6)
					(self setMotion: MoveTo (+ x temp2) (+ y temp3))
				)
			)
			((or temp2 temp3)
				(self setMotion: MoveTo (+ x temp2) (+ y temp3))
			)
			(dir
				(self setMotion: 0 heading: (* (- dir 1) 45))
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
)

(class Ego of Act
	(properties
		signal 8192
		edgeHit 0
	)

	(method (init)
		(super init:)
		(if (not cycler)
			(self setCycle: Walk)
		)
	)

	(method (doit)
		(super doit:)
		(= edgeHit
			(cond
				((<= x global63) 4)
				((<= y (gCurRoom horizon:)) 1)
				((>= x global62) 2)
				((>= y global61) 3)
				(else 0)
			)
		)
	)

	(method (get param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory at: [param1 temp0]) moveTo: self)
		)
	)

	(method (put param1 param2)
		(if (self has: param1)
			((gInventory at: param1) moveTo: (if (== argc 1) -1 else param2))
		)
	)

	(method (has param1 &tmp temp0)
		(if (= temp0 (gInventory at: param1))
			(temp0 ownedBy: self)
		)
	)
)

(class Head of Prop
	(properties
		cycleSpeed 6
		syncMouth 0
		client 0
		cycleCnt 0
		moveHead 1
		headCel {15372406}
	)

	(method (init param1)
		(= view (param1 view:))
		(= loop (- (NumLoops param1) 4))
		(self
			client: param1
			ignoreActors: 1
			posn:
				(param1 x:)
				(param1 y:)
				(CelHigh view (param1 loop:) (param1 cel:))
		)
		(if (& (param1 signal:) $0010)
			(self setPri: (param1 priority:))
		)
		(param1 head: self)
		(super init:)
		(if moveHead
			(self cue: look:)
		)
	)

	(method (cue)
		(if (and (not (gCurRoom script:)) moveHead)
			(client look: (- (Random 0 2) 1))
		)
		(Timer set60ths: self (Random 60 150))
	)

	(method (doit)
		(if moveHead
			(self setPri: (client priority:) look:)
			(if (!= (self view:) (client view:))
				(self view: (client view:) loop: (- (NumLoops client) 4))
			)
			(= x (client x:))
			(= y (client y:))
			(= z (CelHigh (client view:) (client loop:) (client cel:)))
		)
		(super doit:)
	)

	(method (look &tmp temp0 temp1)
		(if (== (= temp0 (client loop:)) (- (NumLoops client) 1))
			(= temp0 (client cel:))
			(= temp1 (client lookingDir:))
		else
			(= temp1 0)
		)
		(= cel (+ (& (StrAt headCel temp0) $000f) temp1))
	)
)

(class CDActor of Act
	(properties
		head 0
		gesture 0
		oldScript 0
		caller 0
		lookingDir 0
	)

	(method (init param1)
		(super init:)
		(self head: 0 gesture: (if argc param1 else 0))
	)

	(method (cue)
		(if head
			(head setCel: 0 syncMouth: 0 setCycle: 0)
		)
		(if gesture
			(self setScript: oldScript)
		)
		(if caller
			(caller cue:)
		)
	)
)

(class Body of Ego
	(properties
		head 0
		caller 0
		lookingDir 1
		normal 1
	)

	(method (init)
		(super init:)
		(if (not head)
			((= head (Head new:)) init: self posn: 267 165)
		)
		(= looper MyLooper)
	)

	(method (look param1)
		(= lookingDir param1)
	)

	(method (cue)
		(if head
			(head setCel: 0 syncMouth: 0 setCycle: 0)
		)
		(if caller
			(caller cue:)
		)
	)

	(method (dispose)
		(= head 0)
		(super dispose:)
	)
)

(class Blk of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
	)

	(method (doit theObj)
		(return
			(or
				(<= (theObj brBottom:) top)
				(> (theObj brTop:) bottom)
				(< (theObj brRight:) left)
				(>= (theObj brLeft:) right)
			)
		)
	)
)

(class Cage of Blk
	(properties)

	(method (doit theObj)
		(return
			(and
				(>= (theObj brTop:) top)
				(>= (theObj brLeft:) left)
				(<= (theObj brBottom:) bottom)
				(<= (theObj brRight:) right)
			)
		)
	)
)

