;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(class Feature of Obj
	(properties
		y 0
		x 0
	)

	(method (dispose)
		(gFeatures delete: self)
		(super dispose:)
	)

	(method (handleEvent))
)

(class PV of Feature
	(properties
		view 0
		loop 0
		cel 0
		priority 0
		signal 0
	)

	(method (init)
		((View new:)
			view: view
			loop: loop
			cel: cel
			x: x
			y: y
			priority: priority
			init:
			signal: (| signal $8021)
		)
		(= global55 1)
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

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
		(BaseSetter self)
		(self forceUpd:)
	)

	(method (dispose)
		(self startUpd: hide:)
		(|= signal $8000)
		(= global55 1)
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
		(self init: signal: (| signal $8021))
		(= global55 1)
	)

	(method (handleEvent))

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
		(super handleEvent: event)
		(if script
			(script handleEvent: event)
		)
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
		(if script
			(script dispose:)
		)
		(if (= script newScript)
			(script init: self)
		)
	)
)

(class Act of Prop
	(properties
		illegalBits -32768
		xLast 0
		yLast 0
		xStep 3
		heading 0
		moveSpeed 0
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
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
		(&= signal $fbff)
		(if script
			(script doit:)
		)
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
		(super posn: newX newY)
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
			(avoider client: self init:)
		)
	)

	(method (isStopped)
		(return
			(or
				(not (IsObject mover))
				(and (== x xLast) (== y yLast) (mover triedToMove:))
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
				(switch legDir
					(0
						(= x (- xOrg legLen))
						(= y yOrg)
					)
					(1
						(= x (+ xOrg legLen))
					)
					(2
						(= x (- xOrg legLen))
						(= y (- yOrg legLen))
					)
					(3
						(= x (+ xOrg legLen))
						(= y (- yOrg legLen))
					)
					(4
						(= x (- xOrg legLen))
						(= y (+ yOrg legLen))
					)
					(5
						(= x (+ xOrg legLen))
						(= y (+ yOrg legLen))
					)
					(6
						(= x xOrg)
						(= y (- yOrg legLen))
					)
					(7
						(= y (+ yOrg legLen))
					)
				)
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
			(OnControl x y)
		else
			(OnControl brLeft brTop brRight brBottom)
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

	(method (setDirection dir &tmp temp0 temp1 temp2 temp3)
		(if (== dir 0)
			(self setMotion: 0)
			(return)
		)
		(if
			(and
				mover
				(==
					dir
					(cond
						((== heading 0) 1)
						((< heading 90) 2)
						((== heading 90) 3)
						((< heading 180) 4)
						((== heading 180) 5)
						((< heading 270) 6)
						((== heading 270) 7)
						(else 8)
					)
				)
			)
			(return)
		)
		(= temp0 x)
		(= temp1 y)
		(= temp2 (* xStep 400))
		(= temp3 (* yStep 400))
		(switch dir
			(1
				(-= temp1 temp3)
			)
			(2
				(+= temp0 temp2)
				(-= temp1 temp3)
			)
			(3
				(+= temp0 temp2)
			)
			(4
				(+= temp0 temp2)
				(+= temp1 temp3)
			)
			(5
				(+= temp1 temp3)
			)
			(6
				(-= temp0 temp2)
				(+= temp1 temp3)
			)
			(7
				(-= temp0 temp2)
			)
			(8
				(-= temp0 temp2)
				(-= temp1 temp3)
			)
		)
		(self setMotion: MoveTo temp0 temp1)
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
				((<= x 0) 4)
				((<= y (gCurRoom horizon:)) 1)
				((>= x 319) 2)
				((>= y 189) 3)
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

