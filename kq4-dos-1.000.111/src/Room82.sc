;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	Room82 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0)
	(= gLolotteDoorUnlocked 1)
	(Print 82 0) ; "Using the little gold key you quickly unlock the door."
	(gGame changeScore: 2)
)

(instance theMusic of Sound
	(properties
		number 45
	)
)

(instance Room82 of Rm
	(properties
		picture 82
		style 16
	)

	(method (init)
		(Load rsVIEW 605)
		(Load rsVIEW 122)
		(Load rsVIEW 123)
		(Load rsVIEW 85)
		(Load rsVIEW 68)
		(Load rsVIEW 633)
		(Load rsVIEW 646)
		(Load rsSOUND 46)
		(Load rsSOUND 45)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		(Notify 604 0)
		((View new:) view: 633 loop: 4 cel: 0 posn: 61 84 setPri: 4 addToPic:)
		((View new:) view: 633 loop: 4 cel: 0 posn: 38 88 setPri: 5 addToPic:)
		(if gNight
			((Prop new:)
				view: 633
				loop: 0
				posn: 62 70
				setPri: 3
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 633
				loop: 1
				posn: 39 74
				setPri: 4
				init:
				setCycle: Fwd
			)
			((= local7 (Prop new:))
				view: 646
				loop: 0
				cel: 0
				posn: 92 93
				cycleSpeed: 5
				init:
				stopUpd:
			)
			((= local8 (Prop new:))
				view: 646
				loop: 1
				cel: 0
				posn: 225 94
				cycleSpeed: 5
				init:
				stopUpd:
			)
		)
		(gEgo
			posn: 233 166
			view: 4
			setStep: 4 1
			baseSetter: 0
			ignoreActors: 0
			illegalBits: $c000
			setPri: -1
			init:
		)
		(if gLolotteAlive
			((= local0 (Act new:))
				view: 122
				illegalBits: 0
				posn: 162 94
				init:
				stopUpd:
			)
			((= local2 (Prop new:))
				view: 123
				posn: (local0 x:) (- (local0 y:) 20)
				init:
				hide:
			)
			((= local3 (Prop new:))
				view: 605
				cel: 0
				posn: 234 155
				init:
				stopUpd:
				ignoreActors: 0
			)
		else
			((= local3 (Prop new:))
				view: 605
				posn: 234 153
				init:
				stopUpd:
				ignoreActors: 1
			)
			((= local0 (Act new:))
				view: 123
				illegalBits: 0
				posn: 162 94
				setLoop: 1
				setCel: 255
				init:
				stopUpd:
			)
			(if (== ((gInventory at: 2) owner:) 82) ; Talisman
				((= local1 (View new:))
					view: 123
					loop: 3
					posn: 172 95
					setPri: 6
					init:
				)
			)
			(gEgo illegalBits: $8000)
			(local3 setCel: 255)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 88)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((not (& (gEgo onControl: 0) $0800))
						(cond
							(
								(or
									(Said 'look[<around][/!*]')
									(Said 'look[<around]/room')
									(Said 'look/castle,tower,bedroom')
								)
								(Print
									(Format ; "So, this is Lolotte's bed chamber. You question her taste in decorating as her furniture is a bit on the gaudy side. %s"
										@global300
										82
										1
										(if (== (local0 view:) 122)
											{And speaking of Lolotte...the old bat is sound asleep on her massive bed.}
										else
											{However, since Lolotte is now dead, it doesn't really matter anymore.}
										)
									)
								)
							)
							((Said 'look>')
								(cond
									((Said '<under/bed')
										(Print 82 2) ; "There is nothing under the bed."
									)
									((Said '/bed')
										(Print 82 3) ; "The bed is huge and takes up most of the room."
									)
									((Said '/window')
										(if
											(or
												(gEgo inRect: 66 118 131 131)
												(gEgo
													inRect: 196 118 240 135
												)
											)
											(Print 82 4) ; "You see the mountain out the window."
										else
											(NotClose) ; "You're not close enough."
										)
									)
									((Said '/wall')
										(Print 82 5) ; "There is nothing of importance on the walls."
									)
									((Said '/dirt')
										(Print 82 6) ; "There is nothing of importance on the floor."
									)
									((Said '/carpet')
										(Print 82 7) ; "A massive rug adorns the floor."
									)
									((Said '/mirror')
										(if (gEgo inRect: 42 123 108 144)
											(Print 82 8) ; "You look in the mirror and see the reflection of a poor, but beautiful, peasant girl."
										else
											(NotClose) ; "You're not close enough."
										)
									)
									((Said '/stair')
										(Print 82 9) ; "How can you even see the stairs from here?"
									)
									((Said '/door')
										(Print 82 10) ; "It's just a wooden door."
									)
									((Said '/lolotte,fairies')
										(if gLolotteAlive
											(Print 82 11) ; "The evil fairy sleeps soundly in her bed. She wears Genesta's magic talisman around her neck, and you see it gleaming upon her chest. As she sleeps, she makes very strange clicking sounds."
										else
											(Print
												(Format ; "Lolotte is quite dead now. %s"
													@global300
													82
													12
													(if
														(==
															((gInventory at: 2) ; Talisman
																owner:
															)
															82
														)
														{\nGenesta's magic talisman hangs from around her neck.}
													else
														{ }
													)
												)
											)
										)
									)
									(else
										(event claimed: 0)
									)
								)
							)
							((Said 'help,save/lolotte,fairies')
								(Print 82 13) ; "Why would you want to?"
							)
							((Said 'kiss[/lolotte,fairies]')
								(if gLolotteAlive
									(Print 82 14) ; "That would be a bad idea!"
								else
									(Print 82 15) ; "She's dead now. Are you sure this is a good idea?"
								)
							)
							((Said 'give>')
								(Print 82 16) ; "Do you honestly think Lolotte needs anything from you?"
								(event claimed: 1)
							)
							((Said 'awaken/lolotte,fairies')
								(if gLolotteAlive
									(gCurRoom setScript: egoZapped)
								else
									(Print 82 17 #font gSmallFont #at 15 20 #time 4) ; "Waking the dead is a little more than even a princess can do!"
								)
							)
							((Said 'get,capture/lolotte,fairies')
								(if gLolotteAlive
									(Print 82 18) ; "You wouldn't want her."
								else
									(Print 82 15) ; "She's dead now. Are you sure this is a good idea?"
								)
							)
							((Said 'talk[<lolotte,fairies]')
								(if gLolotteAlive
									(gCurRoom setScript: egoZapped)
								else
									(Print 82 19 #time 5) ; "Lolotte is unable to talk, as she is now dead."
								)
							)
							((Said 'blow/whistle')
								(if gLolotteAlive
									(gCurRoom setScript: egoZapped)
								else
									(event claimed: 0)
								)
							)
							((Said 'get/amulet')
								(cond
									((gEgo has: 2) ; Talisman
										(Print 82 20 #time 3) ; "You're already carrying it."
									)
									((!= ((gInventory at: 2) owner:) 82) ; Talisman
										(Print 82 21 #time 5) ; "You don't see it here."
									)
									((not (gEgo inRect: 120 120 215 135))
										(Print 82 22 #time 3) ; "You'll have to get a little closer."
									)
									(gLolotteAlive
										(gCurRoom setScript: egoZapped)
									)
									(else
										(Print 82 23 #time 2) ; "Ok."
										(gEgo get: 2) ; Talisman
										(local1 dispose:)
										(= global182 1)
										(gGame changeScore: 5)
									)
								)
							)
							((Said 'close/door')
								(if (== (local3 cel:) 0)
									(Print 82 24) ; "It already is."
								else
									(Print 82 25) ; "You don't need to."
								)
							)
							(
								(or
									(Said 'lay<down,sleep')
									(Said
										'(sleep<in,on),(lay<down,in,on),(get<in,on)/bed'
									)
								)
								(Print 82 26) ; "Not with Lolotte in it!!"
							)
							((Said 'kill/lolotte,fairies')
								(cond
									((== gLolotteAlive 0)
										(Print 82 27) ; "She is already dead."
									)
									((gEgo has: 14) ; Cupid_s_Bow
										(Print 82 28) ; "It's tempting, but you don't have it in you."
									)
									(else
										(Print 82 29) ; "You have no way of doing that."
									)
								)
							)
							((Said 'launch[/!*]')
								(Print 82 30) ; "Shoot what?"
							)
							((Said 'launch/lolotte,fairies,arrow,arrow')
								(cond
									((>= ((gInventory at: 14) loop:) 2) ; Cupid_s_Bow
										(Print 82 31) ; "Sorry, girl, you have no more arrows!"
									)
									((not gLolotteAlive)
										(Print 82 32) ; "She already is dead."
									)
									((== (gCurRoom script:) lolotteDead)
										(Print 82 33) ; "She is dying."
									)
									(else
										(self setScript: shootLolotte)
									)
								)
							)
						)
					)
					((Said 'look/stair')
						(Print 82 34) ; "The stone stairway leads down the tower."
					)
					((Said 'look/wall')
						(Print 82 5) ; "There is nothing of importance on the walls."
					)
					((Said 'look/door')
						(Print 82 35) ; "It's just a plain wooden door."
					)
					((Said 'open/window')
						(Print 82 36) ; "The windows do not open."
					)
					((Said 'break/window')
						(Print 82 37) ; "That would not accomplish anything."
					)
					((Said 'look[<around][/room]')
						(Print 82 38) ; "You see Lolotte's bedroom door, and a winding stairway leading down the tower."
					)
					((Said 'unlatch/door>')
						(cond
							(gLolotteDoorUnlocked
								(event claimed: 1)
								(Print 82 24) ; "It already is."
							)
							((> (gEgo distanceTo: local3) 15)
								(event claimed: 1)
								(NotClose) ; "You're not close enough."
							)
							(
								(or
									(and
										(gEgo has: 32) ; Gold_Key
										(not (gEgo has: 20)) ; Skeleton_Key
									)
									(and
										(Said '*/*/(key<gold)')
										(gEgo has: 32) ; Gold_Key
									)
								)
								(event claimed: 1)
								(localproc_0)
							)
							((and (Said '*/*/key<skeleton') (gEgo has: 20)) ; Skeleton_Key
								(Print 82 39) ; "The skeleton key does not fit the lock."
							)
							((and (gEgo has: 20) (gEgo has: 32)) ; Skeleton_Key, Gold_Key
								(event claimed: 1)
								(Print 82 40) ; "Which key do you want to use; the gold key, or the skeleton key?"
								(= local4 1)
							)
							(else
								(event claimed: 1)
								(Print 82 41) ; "How can you do that without a key?"
							)
						)
					)
					((or (Said '[use]/key<gold') (Said '/gold'))
						(cond
							((not (gEgo has: 32)) ; Gold_Key
								(Print 82 42) ; "You don't have it."
							)
							((> (gEgo distanceTo: local3) 15)
								(event claimed: 1)
								(NotClose) ; "You're not close enough."
							)
							(gLolotteDoorUnlocked
								(Print 82 43) ; "The door is already unlocked."
							)
							((or local4 (not (gEgo has: 20))) ; Skeleton_Key
								(localproc_0)
							)
							(else
								(Print 82 44) ; "What do you want to do with the gold key?"
							)
						)
					)
					((or (Said '[use]/key<skeleton') (Said '/skeleton'))
						(if (and (gEgo has: 20) local4 (not gLolotteDoorUnlocked)) ; Skeleton_Key
							(Print 82 39) ; "The skeleton key does not fit the lock."
						else
							(Print 82 45) ; "What do you want to do with the skeleton key?"
						)
					)
					((Said 'open/door')
						(if (< (gEgo distanceTo: local3) 15)
							(cond
								((and gLolotteDoorUnlocked (== (local3 cel:) 0))
									(User canControl: 0 canInput: 0)
									(local3
										startUpd:
										ignoreActors: 1
										setCycle: End doDoor
									)
									(gEgo stopUpd:)
									((Sound new:) number: 300 loop: 1 play:)
								)
								((not gLolotteDoorUnlocked)
									(Print 82 46) ; "Unlock it first."
								)
								(else
									(Print 82 47) ; "It is already open."
								)
							)
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said 'close/door')
						(if (== (local3 cel:) 0)
							(Print 82 24) ; "It already is."
						else
							(Print 82 25) ; "You don't need to."
						)
					)
				)
			)
		)
	)
)

(instance doDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 stopUpd:)
				(User canControl: 1 canInput: 1)
				(gEgo illegalBits: $8000 startUpd:)
			)
		)
	)
)

(instance lolotteDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic number: 46 loop: 1 play:)
				(= cycles 2)
			)
			(1
				(cls)
				(local0 setCycle: End self)
			)
			(2
				(Print 82 48 #font gSmallFont #width 135 #at 2 20) ; "Lolotte sits straight up in bed, a look of agony upon her face. "What did you do to me?!" she shrieks. "I'm melting...melting!" No, wait! That's another story. Ahem! Let's try again."
				(Print 82 49 #font gSmallFont #width 135 #at 2 20) ; "It hurts! It hurts! Stop the pain! Stop it!"
				(local2
					loop: 2
					cel: 0
					show:
					cycleSpeed: 4
					setCycle: End stopHeart
				)
				(local0
					view: 123
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(Print 82 50 #at -1 20 #font gSmallFont #width 250) ; "You cringe as you watch the evil fairy die a painful death. What happened?, you wonder. How could Cupid's arrow have done that? You thought that those arrows were harmless, and contained only LOVE."
				(local0 loop: 1 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(4
				(Print 82 51 #at -1 20 #width 250 #font gSmallFont) ; "Wait! That must be it! LOVE! Lolotte was so evil that when all that pure love entered her body, it acted as a poison to her system! In spite of yourself, you feel a sense of sweet revenge."
				((= local1 (View new:))
					view: 123
					loop: 3
					posn: 172 95
					init:
					setPri: (+ (local0 priority:) 1)
				)
				(Print 82 52 #at -1 20 #font gSmallFont #width 250) ; "As she breathes her last, Lolotte manages to gasp, "I don't know how...but I'll get you for this...""
				(gGame changeScore: 8)
				(local0 stopUpd:)
				(= gLolotteAlive 0)
				(if (< global160 30)
					(= global160 30)
					(= global159 0)
				)
				(= seconds 3)
			)
			(5
				(Print 82 53 #at -1 20 #font gSmallFont) ; "A bright, new day is dawning!"
				(local7 setCycle: End self)
				(local8 setCycle: End)
				(= gNight 0)
			)
			(6
				(User canControl: 1 canInput: 1)
				(gCurRoom setScript: edsHere)
			)
		)
	)
)

(instance shootLolotte of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(LookAt gEgo local0)
				(gEgo cel: 0 view: 68 cel: 0 setMotion: 0 setCycle: End self)
			)
			(1
				(Print 82 54 #at -1 20 #font gSmallFont) ; "You aim the golden arrow toward Lolotte. You let go of the bow string. ZING! A direct hit!"
				(= seconds 1)
			)
			(2
				(gEgo view: 4 setCycle: Walk)
				((Inv at: 14) loop: (+ ((Inv at: 14) loop:) 1)) ; Cupid_s_Bow, Cupid_s_Bow
				(gCurRoom setScript: lolotteDead)
			)
		)
	)
)

(instance stopHeart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local2 dispose:)
			)
		)
	)
)

(instance egoZapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(local7 startUpd:)
				(local8 startUpd:)
				(theMusic number: 45 loop: 1 play:)
				(local0 setCycle: End self)
			)
			(1
				(local0 loop: 1 setCycle: Fwd)
				(gEgo
					view: 85
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(local0 setCycle: 0 cel: 0)
				(gEgo loop: 1 setCycle: End self)
			)
			(3
				(Print 82 55 #at 15 15 #font gSmallFont) ; "You stupidly wake Lolotte up! "VIPER!" she screams, as she quickly sits up, points a gnarled finger at you, and zaps you into oblivion!"
				((ScriptID 0 4) setReal: self 3) ; timer1
			)
			(4
				(= gDeathFlag 1)
			)
		)
	)
)

(instance edsHere of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 130)
		(Load rsVIEW 132)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic number: 43 loop: 1 play:)
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: 0 loop: 0)
				((= local5 (Act new:))
					view: 130
					illegalBits: 0
					posn: 185 205
					init:
					ignoreActors: 0
					setCycle: Walk
					setMotion: MoveTo 251 162 self
				)
			)
			(1
				(local5
					view: 132
					loop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: CT 3 1 self
				)
				(= seconds 1)
			)
			(2
				(local5 setCycle: CT 0 -1)
				(= seconds 2)
			)
			(3
				(Print 82 56) ; "Edgar bows to you, acknowledging his evil mother's death. He begins to say, "You may now walk freely about the castle. I..." and suddenly begins to blush."
				(local5 view: 132 setLoop: 2 cycleSpeed: 0 setCycle: End)
				(= seconds 3)
			)
			(4
				(local5
					view: 130
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 185 205 self
				)
			)
			(5
				(User canControl: 1 canInput: 1)
				(local5 dispose:)
				(= state -1)
			)
		)
	)
)

