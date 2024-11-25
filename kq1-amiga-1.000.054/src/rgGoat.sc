;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use TurnLooper)
(use LoadMany)
(use Follow)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	rgGoat 0
	goatLooper 1
	killGoat 2
)

(local
	local0
	local1
	local2
)

(instance goatLooper of TurnLooper
	(properties)
)

(instance rgGoat of Rgn
	(properties)

	(method (init)
		(LoadMany rsVIEW 165 167 166)
		(LoadMany rsSCRIPT 985 971 982)
		(super init: &rest)
		(goatLooper viewChange: 167)
		(gGoat
			view: 165
			ignoreHorizon: 1
			illegalBits: $e23e
			setLoop: -1
			setPri: -1
			looper: goatLooper
			setAvoider:
				(cond
					((OneOf gCurRoomNum 10 11 15 16 23) 0)
					((OneOf gCurRoomNum 25 39 41)
						(Avoid offScreenOK: 0)
					)
					(else
						(Avoid offScreenOK: 1)
					)
				)
			setCycle: Walk
			setMotion: Follow gEgo 60
			init:
		)
		(switch gPrevRoomNum
			((gCurRoom west:)
				(switch gPrevRoomNum
					(15
						(gGoat
							posn:
								-20
								(proc0_17
									90
									(gGoat y:)
									(+ (gCurRoom horizon:) 2)
								)
						)
					)
					(else
						(gGoat posn: (- (gEgo x:) 30) (+ (gEgo y:) 2))
					)
				)
			)
			((gCurRoom east:)
				(switch gPrevRoomNum
					(16
						(gGoat
							posn:
								340
								(proc0_17
									90
									(gGoat y:)
									(+ (gCurRoom horizon:) 2)
								)
						)
					)
					(11
						(if (<= (gEgo y:) 77)
							(gGoat
								posn: (+ (gEgo x:) 20) (- (gEgo y:) 2)
							)
						else
							(gGoat
								posn: (+ (gEgo x:) 20) (+ (gEgo y:) 2)
							)
						)
					)
					(else
						(gGoat posn: (+ (gEgo x:) 30) (+ (gEgo y:) 2))
					)
				)
			)
			((gCurRoom north:)
				(switch gPrevRoomNum
					(14
						(gGoat posn: (gEgo x:) (gCurRoom horizon:))
					)
					(30
						(gGoat posn: (- (gEgo x:) 25) 50)
					)
					(32
						(gGoat
							posn:
								(proc0_17 309 (- (gEgo x:) 25) 240)
								(gEgo y:)
						)
					)
					(else
						(if (< (gEgo x:) 160)
							(gGoat posn: (- (gEgo x:) 25) (gEgo y:))
						else
							(gGoat posn: (+ (gEgo x:) 25) (gEgo y:))
						)
					)
				)
			)
			((gCurRoom south:)
				(if (> (gEgo x:) 160)
					(gGoat posn: (+ (gEgo x:) 5) (+ (gEgo y:) 30))
				else
					(gGoat posn: (- (gEgo x:) 5) (+ (gEgo y:) 30))
				)
			)
		)
		(= global129 gCurRoomNum)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 2) local0 (> (gEgo distanceTo: gGoat) 120))
			(if (and global130 (& (gEgo onControl: 1) $059e))
				(Print 600 0) ; "As you move further away from the goat, he forgets about your carrot and begins to wander off on his own."
			else
				(Print 600 1) ; "The goat decides it would be easier to stop following you than to get his fur wet."
			)
			(= local0 0)
			(ClearFlag 2)
			(gGoat setScript: goatBobs)
		)
		(if
			(and
				global130
				(IsFlag 2)
				(not local0)
				(& (gEgo onControl: 1) $0002)
			)
			(= local0 1)
			(gGoat setMotion: 0)
			(if (not local1)
				(= local1 1)
				(Print 600 2) ; "The goat does not mind getting its feet wet, but will not swim in the water. You should go back and lead the goat around the water."
			)
		)
		(if
			(and
				(> (gGoat y:) (gCurRoom horizon:))
				(gGoat ignoreHorizon:)
			)
			(gGoat ignoreHorizon: 0)
		)
		(if (and (not global130) local0 (IsFlag 2))
			(= local0 0)
			(gGoat setMotion: Follow gEgo 60)
		)
		(if
			(and
				(IsFlag 1)
				(OneOf gCurRoomNum 25 39 41)
				(!= (gCurRoom script:) goatLeaves)
				(IsFlag 2)
			)
			(= local2 1)
			(gCurRoom setScript: goatLeaves)
		)
	)

	(method (newRoom newRoomNumber)
		(if global130
			(Print 600 3) ; "Seeing you swim away, the goat decides you've abandoned him and wanders off on his own."
			(ClearFlag 2)
		)
		(super newRoom: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'hit,kick/goat')
				(if global119
					(Print 600 4) ; "That would be very much like beating a dead horse, wouldn't it?"
				else
					(Print 600 5) ; "A gallant knight such as yourself would never attack an innocent goat."
				)
			)
			((Said 'look,look/goat')
				(cond
					((IsFlag 2)
						(Print 600 6) ; "The old goat, trotting briskly, seems happy to be with you."
					)
					((== (gGoat script:) goatBobs)
						(Print 600 7) ; "The goat is wandering nearby."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((or (Said 'kill/goat/shot') (Said 'shoot/goat'))
				(cond
					((and (gEgo has: 10) (gEgo has: 9)) ; Leather_Slingshot, Pebbles
						(Print 600 8) ; "Pelting the goat with pebbles would be a slow and painful way to kill him. If you feel you absolutely must do away with him, use a quicker method."
					)
					((or (not (gEgo has: 10)) (not (gEgo has: 9))) ; Leather_Slingshot, Pebbles
						(Print 600 9) ; "You don't have all you need in order to try something like that."
					)
				)
			)
			((Said 'capture,pull,pull,get,get/goat')
				(if (IsFlag 2)
					(Print 600 10) ; "Why? The goat seems to be following you quite nicely."
				else
					(Print 600 11) ; "You blew your chance with the goat."
				)
			)
			((Said 'stab,kill/goat')
				(cond
					(global119
						(Print 600 12) ; "He's already dead, it just wouldn't be the same."
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((> (gEgo distanceTo: gGoat) 35)
						(Print 600 13) ; "You should get closer to the goat first."
					)
					((not (gEgo has: 0)) ; Dagger
						(Print 600 14) ; "You don't have anything suitable for bringing a quick end to the goat."
					)
					(else
						(gCurRoom setScript: killGoat)
					)
				)
			)
			(
				(or
					(Said 'feed,give/carrot[/goat]')
					(Said 'feed,give/goat[/carrot]')
				)
				(cond
					((not (gEgo has: 2)) ; Carrot
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					((== (gGoat view:) 166)
						(cond
							((< (gGoat loop:) 2)
								(Print 600 15) ; "Since you've killed him, the goat just doesn't seem to display the same interest in the carrot."
							)
							((> (gGoat loop:) 1)
								(Print 600 16) ; "The goat is content to graze for now."
							)
						)
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					(
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(gGoat x:)
								(gGoat y:)
							)
							26
						)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 1)
						(Print 600 17) ; "The goat cannot see you or the carrot."
					)
					((== (gGoat script:) goatBobs)
						(if (gEgo has: 2) ; Carrot
							(Print 600 18) ; "The goat seems to be looking for his own food right now."
						else
							(Print 600 19) ; "You don't have a carrot."
						)
					)
					((gEgo has: 2) ; Carrot
						((ScriptID 0 21) number: 44 init: play:) ; gameSound
						(ClearFlag 2)
						(gEgo put: 2) ; Carrot
						(gGame changeScore: -2)
						(if (OneOf gCurRoomNum 25 39 41)
							(gCurRoom setScript: goatLeaves)
						else
							(Print 600 20) ; "Goats love carrots! The goat quickly devours yours and stops following you."
							(gGoat setScript: goatBobs)
						)
					)
					(else
						(Print 600 19) ; "You don't have a carrot."
					)
				)
			)
			(
				(or
					(Said 'show/carrot')
					(Said 'coax,coax/goat')
					(Said 'show/goat/carrot')
					(Said 'coax,coax/goat/carrot')
				)
				(cond
					((not (gEgo has: 2)) ; Carrot
						(Print 600 19) ; "You don't have a carrot."
					)
					(
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(gGoat x:)
								(gGoat y:)
							)
							50
						)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 2)
						(Print 600 21) ; "The goat is already following you! There's no reason to tease him mercilessly."
					)
					((IsFlag 1)
						(Print 600 17) ; "The goat cannot see you or the carrot."
					)
					(else
						(Print 600 22) ; "The goat isn't interested in you anymore."
					)
				)
			)
		)
	)
)

(instance killGoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 600 23) ; "You viciously plunge the dagger deep into the poor goat's back. He struggles in pain, bleating frantically, and finally slumps to the ground."
				(goatKill init: play:)
				(gGoat
					view: 166
					setCel: 0
					setLoop: (if (< (gGoat heading:) 180) 0 else 1)
					setMotion: 0
					setScript: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(goatKill stop:)
				(= global119 gCurRoomNum)
				(= global120 (gGoat x:))
				(= global121 (gGoat y:))
				(= global122 (gGoat loop:))
				(gEgo put: 0) ; Dagger
				(gGame changeScore: -5)
				(ClearFlag 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goatBobs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGoat
					setAvoider: 0
					illegalBits: $c03e
					setMotion:
						MoveTo
						(Random 10 310)
						(Random (+ (gCurRoom horizon:) 2) 180)
				)
				(= cycles (Random 20 40))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance goatLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 2)
				(if local2
					(Print 600 24) ; "The goat doesn't seem to see you anymore."
				else
					(Print 600 25) ; "Goats love carrots! The goat quickly devours yours and wanders away."
				)
				(switch gCurRoomNum
					(25
						(gGoat setMotion: MoveTo (gGoat x:) 220 self)
					)
					(41
						(gGoat setMotion: MoveTo 340 101 self)
					)
					(39
						(gGoat setMotion: MoveTo 340 (gGoat y:) self)
					)
				)
			)
			(1
				(gGoat dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goatKill of Sound
	(properties
		number 104
		priority 10
	)
)

