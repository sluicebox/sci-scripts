;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 914)
(include sci.sh)
(use Main)
(use EgoGroop)
(use Scaler)
(use Grooper)
(use Ego)
(use Motion)

(public
	Body 0
)

(class Body of Ego
	(properties
		normal 1
		currentSpeed 0
		setHeadingCode 0
		oldScaleSignal 0
		oldMaxScale 0
		oldBackSize 0
		oldFrontY 0
		oldBackY 0
		oldXStep 6
		oldYStep 2
	)

	(method (setScale param1)
		(if argc
			(super setScale: param1 &rest)
		else
			(super setScale:)
		)
		(|= scaleSignal $0004)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(cond
			((self isStopped:)
				(if
					(and
						(!= (= temp0 loop) (= temp1 (- (NumLoops self) 1)))
						(gCast contains: self)
						(or (== (gEgo view:) 900) (== (gEgo view:) 308))
						(IsObject cycler)
						(not (cycler isKindOf: Grycler))
						normal
					)
					(self loop: temp1 cel: temp0)
				)
			)
			((and normal (== loop (- (NumLoops self) 1)) (not (& signal $0800)))
				(self loop: cel)
			)
		)
	)

	(method (findStep &tmp temp0 temp1 temp2)
		(= temp0 (if (= temp2 (/ scaleX 15)) temp2 else 1))
		(= temp1 (if (= temp2 (/ scaleY 63)) temp2 else 1))
		(if (or (!= temp0 xStep) (!= temp1 yStep))
			(self setStep: temp0 temp1 1)
		)
	)

	(method (dispose)
		(= oldScaleSignal
			(= oldMaxScale (= oldBackSize (= oldFrontY (= oldBackY 0))))
		)
		(self setScale: 0)
		(super dispose:)
	)

	(method (setLoop param1 &tmp temp0)
		(if
			(= temp0
				(cond
					((== argc 0)
						(super setLoop:)
						0
					)
					((not (IsObject param1))
						(super setLoop: param1 &rest)
						0
					)
					(else param1)
				)
			)
			(if looper
				(looper dispose:)
			)
			((= looper temp0) init: self &rest)
		)
	)

	(method (reset param1 param2)
		(if (> argc 0)
			(gEgo loop: param1)
		)
		(gEgo
			view: (if (> argc 1) param2 else 900)
			signal: 4096
			z: 0
			setLoop: -1
			setLoop: gEgoGroop
			setPri: -1
			setMotion: 0
			illegalBits: 0
			ignoreActors: 0
			ignoreHorizon: 1
			setStep: oldXStep oldYStep
			setCycle: Walk
			normal: 1
			setSpeed: currentSpeed
		)
		(if (and oldScaleSignal (== view 900))
			(cond
				((& oldScaleSignal $0002)
					(= scaleSignal oldScaleSignal)
					(= maxScale oldMaxScale)
				)
				((or oldMaxScale oldBackSize oldFrontY oldBackY)
					(gEgo
						setScale:
							Scaler
							oldMaxScale
							oldBackSize
							oldFrontY
							oldBackY
					)
				)
				(else
					(gEgo setScale:)
				)
			)
			(= oldScaleSignal
				(= oldMaxScale (= oldBackSize (= oldFrontY (= oldBackY 0))))
			)
		)
	)

	(method (put)
		(super put: &rest)
		(gTheIconBar curIcon: (gTheIconBar walkIconItem:))
	)

	(method (setHeading param1 &tmp temp0)
		(if argc
			(= heading param1)
		)
		(cond
			(setHeadingCode
				(setHeadingCode doit: heading &rest)
			)
			(
				(and
					(IsObject (gEgo looper:))
					((gEgo looper:) isKindOf: EgoGroop)
					(not (looper dontHead:))
				)
				(looper doit: self heading (and (>= argc 2) [param1 1]))
			)
			(else
				(if (IsObject (gEgo looper:))
					(if (not ((gEgo looper:) isKindOf: EgoGroop))
						(= temp0 1)
					else
						(= temp0 0)
					)
				else
					(= temp0 1)
				)
				(if temp0
					(DirLoop self heading)
				)
				(if (and (>= argc 2) (IsObject [param1 1]))
					([param1 1] cue: &rest)
				)
			)
		)
	)
)

