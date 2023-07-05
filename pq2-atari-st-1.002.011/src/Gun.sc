;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	Gun 0
)

(local
	local0
)

(instance GunShot of Sound
	(properties
		priority 12
	)
)

(instance Gun of Locale
	(properties)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 43)
	)

	(method (handleEvent event &tmp [temp0 54])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_F6
						(event claimed: 1)
						(cond
							(global106 0)
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							(
								(or
									(not (gEgo has: 1)) ; extra_ammo_clips
									(== [global215 1] [global215 2] 0)
								)
								(Print 150 0) ; "You don't have any extra ammo clips."
							)
							([global215 global207]
								(Print 150 1) ; "Checking your gun, you see that the clip is not yet empty, and you do not reload."
							)
							(else
								(Print 150 2 #time 4) ; "Loaded."
								(if (== global207 1)
									(= global207 2)
								else
									(= global207 1)
								)
							)
						)
					)
					(KEY_F8
						(event claimed: 1)
						(if (not global106)
							(if global204
								(gEgo setScript: holsterGun)
							else
								(gEgo setScript: drawGun)
							)
						)
					)
					(KEY_F10
						(event claimed: 1)
						(if (not global106)
							(gEgo setScript: fireGun)
						)
					)
				)
			)
		)
	)
)

(instance drawGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (gEgo has: 0)) ; hand_gun
						(client setScript: 0)
						(proc0_13) ; "You don't have your gun."
					)
					(global214 0)
					(global106 0)
					(else
						(HandsOff 1)
						(= global214 1)
						(gEgo
							view:
								(switch (gEgo view:)
									(1 5)
									(296 305)
									(0 4)
								)
							setCel: 0
							setCycle: End self
						)
					)
				)
			)
			(1
				(= global214 0)
				(gEgo
					view:
						(switch (gEgo view:)
							(5 7)
							(305 306)
							(4 6)
						)
					setCel: 0
					init:
				)
				(HandsOn 1)
				(= global204 1)
				(client setScript: 0)
				(if global211
					(Print 800 (Random 35 38))
				)
			)
		)
	)
)

(instance fireGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (gEgo has: 0)) ; hand_gun
						(client setScript: 0)
						(proc0_13) ; "You don't have your gun."
					)
					((not global204)
						(Print 150 3) ; "It is standard police procedure to draw your gun before firing it."
						(client setScript: 0)
					)
					(global213 0)
					(global106 0)
					((== [global215 global207] 0)
						(GunShot number: 43 priority: 10 play:)
						(Print 150 4 #time 2) ; "CLICK!"
						(client setScript: 0)
					)
					(else
						(HandsOff 1)
						(GunShot number: 41 priority: 10 play:)
						(= global213 1)
						(-- [global215 global207])
						(= local0 (gEgo illegalBits:))
						(gEgo ignoreActors: ignoreControl: -1)
						(cond
							((or (== (gEgo view:) 6) (== (gEgo view:) 4))
								(gEgo
									view: 4
									loop: (+ 4 (mod (gEgo loop:) 4))
									setCel: 0
									setCycle: End self
								)
							)
							((or (== (gEgo view:) 7) (== (gEgo view:) 5))
								(gEgo
									view: 5
									loop: (+ 4 (mod (gEgo loop:) 4))
									setCel: 0
									setMotion: 0
									setCycle: End self
								)
							)
						)
					)
				)
			)
			(1
				(gEgo ignoreActors: 0 illegalBits: local0)
				(= global213 0)
				(= global205
					(switch (mod (gEgo loop:) 4)
						(0 2)
						(1 4)
						(2 3)
						(3 1)
					)
				)
				(gEgo
					view: (if (== (gEgo view:) 4) 6 else 7)
					loop: (- (gEgo loop:) 4)
					setStep: 3 2
					setCel: 0
					setCycle: Walk
				)
				(client setScript: 0)
				(switch global212
					(0 0)
					(3
						(Print 800 (Random 45 48))
						(gCurRoom newRoom: 92)
					)
					(else
						(Print 800 (Random 40 43))
					)
				)
				(HandsOn 1)
			)
		)
	)
)

(instance holsterGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff 1)
				(gEgo
					view:
						(switch (gEgo view:)
							(7 5)
							(5 5)
							(306 305)
							(305 305)
							(6 4)
							(4 4)
						)
					loop: (mod (gEgo loop:) 4)
					setCel: 255
					setCycle: Beg self
				)
			)
			(1
				(= global204 0)
				(gEgo
					view:
						(switch (gEgo view:)
							(5 1)
							(305 296)
							(4 0)
						)
					setCel: 0
					setCycle: Walk
				)
				(HandsOn 1)
			)
		)
	)
)

