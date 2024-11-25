;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class Feature of Obj
	(properties
		y 0
		x 0
		z 0
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
		(&= signal $ff77)
		(if (not (gCast contains: self))
			(= lsTop (= lsLeft (= lsBottom (= lsRight 0))))
		)
		(BaseSetter self)
		(|= signal $4000)
		(gCast add: self)
	)

	(method (ignoreActors))

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
		(BaseSetter self)
		(self forceUpd:)
	)

	(method (hide)
		(|= signal $0008)
	)

	(method (show)
		(&= signal $fff7)
	)

	(method (dispose)
		(self startUpd: hide:)
		(|= signal $8000)
	)

	(method (delete)
		(if (& signal $8000)
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

	(method (addToPic param1)
		(cond
			((not argc)
				(self init:)
			)
			((not param1)
				(self init:)
			)
		)
		(self signal: (| signal $8021))
	)

	(method (handleEvent))

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (motionCue))
)

(class CView of View
	(properties
		cursorX 232
		cursorY 0
	)
)

(class Prop of View
	(properties
		signal 0
		cycleSpeed 0
		script 0
		cycler 0
	)

	(method (doit &tmp aState)
		(if (& signal $8000)
			(return)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if cycler
			(cycler doit:)
		)
	)

	(method (handleEvent))

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
		heading 0
		moveSpeed 0
		mover 0
		looper 0
		viewer 0
	)

	(method (init)
		(super init:)
		(= xLast x)
		(= yLast y)
		(|= signal $2000)
	)

	(method (doit &tmp temp0)
		(if (& signal $8000)
			(return)
		)
		(&= signal $fbff)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if viewer
			(viewer doit: self)
		)
		(if mover
			(mover doit:)
		)
		(if cycler
			(cycler doit:)
		)
		(= xLast x)
		(= yLast y)
	)

	(method (canBeHere)
		(return 1)
	)

	(method (posn newX newY)
		(super posn: newX newY)
		(= xLast newX)
		(= yLast newY)
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

	(method (isStopped))

	(method (delete)
		(if (& signal $8000)
			(if (!= mover -1)
				(self setMotion: 0)
			)
			(if looper
				(looper dispose:)
				(= looper 0)
			)
			(if viewer
				(viewer dispose:)
				(= viewer 0)
			)
			(super delete:)
		)
	)

	(method (distanceTo))

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

	(method (setDirection &tmp temp0))

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(super motionCue:)
	)

	(method (inRect))
)

