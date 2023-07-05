;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use n030)
(use Print)
(use Sound)
(use Motion)
(use System)

(public
	ShootHandgun 0
	ShootShotgun 1
)

(instance gunSound of Sound
	(properties)
)

(instance ShootHandgun of Code
	(properties)

	(method (doit param1)
		(cond
			(
				(not
					(OneOf
						(gEgo view:)
						0
						1
						2
						3
						5
						9120
						9121
						9122
						9123
						9125
					)
				)
				(gMessager say: 2 22 8 0 0 0) ; "Holster your weapon! There is no tactical rationale for"
			)
			((or (not ((gInventory at: 11) state:)) (not argc)) ; handgun
				(gGame handsOff:)
				(gCurRoom setScript: pullGunScr 0 1)
			)
			(else
				(gGame handsOff:)
				(= global125 [param1 0])
				(= global126 [param1 1])
				(= global127 [param1 2])
				(= global135 [param1 3])
				(= global128 [param1 4])
				(if (> argc 5)
					(= global129 [param1 5])
				)
				(gCurRoom setScript: pullGunScr 0 0)
			)
		)
	)
)

(instance ShootShotgun of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (gInventory at: 12)) ; shotgun
		(if (temp0 state:)
			(temp0 state: (- (temp0 state:) 1))
			(Prints {bang})
			(return 1)
		else
			(Prints {click})
			(return 0)
		)
	)
)

(instance pullGunScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(cond
						((< 68 (gEgo heading:) 113) 9020)
						((< 247 (gEgo heading:) 293) 9024)
						((< 157 (gEgo heading:) 203) 9022)
						(
							(or
								(> (gEgo heading:) 337)
								(< (gEgo heading:) 23)
							)
							9026
						)
						((< 112 (gEgo heading:) 158) 9021)
						((< 202 (gEgo heading:) 248) 9023)
						((< 22 (gEgo heading:) 68) 9027)
						((< 292 (gEgo heading:) 338) 9025)
					)
				)
				(if (OneOf (gEgo view:) 9120 9121 9122 9123 9125)
					(gEgo
						scaleY: (/ (* (gEgo scaleY:) 130) 100)
						scaleX: (/ (* (gEgo scaleX:) 130) 100)
						setScaler: 0
					)
				)
				(gEgo
					view: temp0
					setLoop: 0
					cel: 0
					scaleSignal: 1
					setCycle: End self
				)
			)
			(1
				(gunSound number: (if register 12 else 926) loop: 1 play: self)
			)
			(2
				(cond
					(register
						(proc30_0 2 22 9 1 0)
					)
					((!= global129 -1)
						(proc30_0
							global125
							global126
							global127
							global135
							global128
							global129
						)
					)
					(else
						(proc30_0
							global125
							global126
							global127
							global135
							global128
						)
					)
				)
			)
		)
	)
)

