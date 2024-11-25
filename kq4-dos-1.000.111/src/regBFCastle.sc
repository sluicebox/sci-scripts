;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 604)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	regBFCastle 0
)

(local
	local0
	local1
	local2
	local3
)

(instance henchCatchMusic of Sound
	(properties
		keep 1
	)
)

(instance henchChaseMusic of Sound
	(properties
		keep 1
	)
)

(instance regBFCastle of Rgn
	(properties)

	(method (init)
		(= keep 1)
		(Load rsVIEW 355)
		(Load rsVIEW 356)
		(Load rsVIEW 358)
		(= global189 1)
		(if (< gAct 5)
			(= local3 92)
		)
		(super init:)
	)

	(method (doit)
		(if
			(and
				(!= global105 16)
				gLolotteAlive
				(== (gEgo script:) 0)
				(gCast contains: local2)
				(== (local2 script:) 0)
				(or
					(and
						(or (== gCurRoomNum 92) (== gCurRoomNum 91))
						(< (gEgo y:) 140)
						(< (gEgo distanceTo: local2) 45)
						(> (Random 1 1000) 996)
					)
					(< (gEgo distanceTo: local2) 20)
				)
			)
			(local2 setScript: henchChaseReg)
		)
		(super doit:)
	)

	(method (dispose)
		(if (== keep 0)
			(henchCatchMusic keep: 0)
			(henchChaseMusic keep: 0)
			(gSounds eachElementDo: #dispose)
			(= global189 0)
			(super dispose:)
		)
	)

	(method (notify param1)
		(initializeRoom changeState: param1)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 30)
			(gSounds eachElementDo: #dispose)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'blow/whistle')
						(if (gEgo has: 27) ; Silver_Whistle
							(Print 604 0) ; "That is not a good idea now."
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said 'look/wall')
						(Print 604 1) ; "There is nothing of interest on the walls."
					)
					((and (gCast contains: local2) (Said 'talk[/goon,man]'))
						(if (and gLolotteAlive (not global175))
							(if (< (gEgo distanceTo: local2) 40)
								(local2 setScript: henchChaseReg)
							else
								(Print 604 2) ; "You are not close enough."
							)
						else
							(Print 604 3 #at -1 20) ; "Lolotte's henchmen must not speak, as you only hear them utter guttural sounds."
						)
					)
					((Said '/goon,man>')
						(cond
							((not (gCast contains: local2))
								(Print 604 4) ; "You don't see one of Lolotte's henchmen here."
								(event claimed: 1)
							)
							((Said 'look')
								(if (and gLolotteAlive (not global175))
									(Print 604 5) ; "The henchman is asleep."
								else
									(Print 604 6 #at -1 20) ; "Lolotte's goons are not appealing at all! Besides having an unnatural pallor to their skin, they are creepy little creatures who fly upon wings that resemble those of bats."
								)
							)
							((Said 'awaken')
								(if (and gLolotteAlive (not global175))
									(if (< (gEgo distanceTo: local2) 40)
										(local2 setScript: henchChaseReg)
									else
										(Print 604 2) ; "You are not close enough."
									)
								else
									(Print 604 7) ; "They already are."
								)
							)
							((Said 'get,capture')
								(Print 604 8) ; "Why would you want one?!"
							)
							((Said 'kiss')
								(Print 604 9) ; "That's an AWFUL thought!"
							)
							((Said 'give')
								(Print 604 10) ; "The henchmen are not interested in your offering."
								(event claimed: 1)
							)
						)
					)
					((Said '/bird,crow>')
						(cond
							((not (gCast contains: local0))
								(Print 604 11) ; "You don't see a raven here."
								(event claimed: 1)
							)
							((Said 'look')
								(Print 604 12) ; "You see Lolotte's raven spying on you."
							)
							((Said 'talk')
								(Print 604 13) ; "Caw! Caw!"
							)
							((Said 'get,capture')
								(Print 604 14) ; "You wouldn't want it even if you could get it."
							)
							((Said 'kiss')
								(Print 604 15) ; "Not this bird!"
							)
							((Said 'give')
								(Print 604 16) ; "The raven is not interested in anything you have."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance initializeRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== gCurRoomNum 91) (== gCurRoomNum 92))
					((= local1 (Prop new:))
						view: 358
						loop: 0
						cel: 0
						posn:
							(switch gCurRoomNum
								(91 258)
								(92 275)
							)
							(switch gCurRoomNum
								(91 136)
								(92 156)
							)
						init:
						stopUpd:
						setScript: ravenStuff
					)
				)
				(if
					(and
						(> gAct 3)
						gLolotteAlive
						(or
							(== gCurRoomNum 90)
							(== gCurRoomNum 91)
							(== gCurRoomNum 92)
							(== gCurRoomNum 93)
						)
					)
					((= local2 (Act new:))
						view: 145
						loop: 4
						cel: (if (== gCurRoomNum 90) 1 else 0)
						posn:
							(switch gCurRoomNum
								(90 188)
								(91 210)
								(92 200)
								(93 124)
							)
							(switch gCurRoomNum
								(90 128)
								(91 119)
								(92 128)
								(93 129)
							)
						init:
						setAvoider: Avoid
						stopUpd:
					)
				)
			)
		)
	)
)

(instance ravenStuff of Script
	(properties)

	(method (doit)
		(if (and (== gCurRoomNum local3) (not (gCast contains: local0)))
			(self changeState: 0)
		)
		(if
			(and
				(gCast contains: local0)
				(!= (local0 priority:) (local1 priority:))
			)
			(local0 setPri: (CoordPri (local1 y:)))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(not (gCast contains: local0))
						(== gCurRoomNum local3)
						(or (== gCurRoomNum 91) (== gCurRoomNum 92))
					)
					((= local0 (Act new:))
						view: 356
						ignoreActors: 1
						illegalBits: 0
						xStep: 6
						yStep: 2
						posn:
							(switch gCurRoomNum
								(91 316)
								(92 51)
							)
							(switch gCurRoomNum
								(91 90)
								(92 81)
							)
						init:
					)
					(local0
						setPri: (+ (local1 priority:) 1)
						setCycle: Fwd
						setMotion: MoveTo (local1 x:) (- (local1 y:) 60) self
					)
				else
					(self changeState: 5)
				)
			)
			(1
				(local0
					setPri: (local1 priority:)
					setMotion: MoveTo (local1 x:) (- (local1 y:) 40) self
				)
			)
			(2
				(local0 view: 355 loop: 3 setMotion: 0 setScript: preenShit)
				(= seconds 30)
			)
			(3
				(local0 setScript: 0 setCycle: 0)
				(local0 cel: 0 loop: 2 setCycle: End self)
			)
			(4
				(local0
					setScript: 0
					view: 356
					setPri: 11
					setLoop: -1
					setCycle: Fwd
					setMotion:
						MoveTo
						(switch gCurRoomNum
							(91 316)
							(92 53)
						)
						(switch gCurRoomNum
							(91 103)
							(92 81)
						)
						self
				)
			)
			(5
				(if (gCast contains: local0)
					(local0 dispose:)
				)
				(if (== local3 92)
					(= local3 91)
				else
					(= local3 92)
				)
				(self cue:)
			)
			(6
				(= state -1)
				(= seconds 30)
			)
		)
	)
)

(instance preenShit of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (/ (Random 0 59) 10)
					(1
						(local0 loop: 0 setCycle: End self)
					)
					(2
						(local0 loop: 1 setCycle: End self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(local0 loop: 3)
				((ScriptID 0 8) setReal: self 4) ; timer5
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance henchChaseReg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local2 loop: 2 setCycle: End self)
			)
			(1
				(local2 loop: 0 setCycle: End self)
			)
			(2
				(= global175 1)
				(if (not (gCast contains: local2))
					(local2
						setStep: 6 3
						posn:
							(switch gCurRoomNum
								(93
									(- (gEgo x:) 30)
								)
								(91
									(+ (gEgo x:) 30)
								)
							)
							(gEgo y:)
						init:
					)
				)
				(local2
					view: 141
					ignoreActors: 1
					setStep: 6 3
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
				(henchChaseMusic number: 41 loop: 1 play:)
			)
			(3
				(User canControl: 0 canInput: 0)
				(gEgo moveSpeed: 0 setMotion: 0)
				(henchChaseMusic dispose:)
				(henchCatchMusic number: 42 loop: 1 play:)
				(= seconds 4)
			)
			(4
				(henchCatchMusic dispose:)
				(= global205 1)
				(gCurRoom newRoom: 81)
			)
		)
	)
)

