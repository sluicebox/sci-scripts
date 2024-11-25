;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
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
	rm20 0
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
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance larrySound of Sound
	(properties
		number 28
	)
)

(instance theBlonde of Sound
	(properties
		number 21
	)
)

(instance larry of Act
	(properties
		view 81
		loop 3
		cycleSpeed 2
	)

	(method (init)
		(larry posn: 231 124 setPri: 1)
		(if (< global110 30)
			(larry stopUpd:)
		else
			(larry setScript: larryActions)
		)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((not (gEgo inRect: 222 124 265 135))
				(if (Said '/jerk')
					(proc0_7) ; "You're not close enough."
				)
				(return)
			)
			((Said 'look/man,jerk')
				(localproc_0 20 0) ; "This man looks so bored that you want to talk to him."
			)
			((Said 'frisk,arrest,arrest/man,jerk')
				(localproc_0 20 1) ; "Don't hurt me! I'm a victim of circumstances!"
			)
			((Said 'show,flash/badge')
				(if (gEgo has: 7) ; wallet
					(localproc_0 20 2) ; "I didn't do it! She made me!"
				else
					(localproc_0 20 3) ; "You don't have your identification with you."
				)
			)
			((Said 'talk/man,jerk')
				(= local16 0)
				(switch local4
					(0
						(larrySound play:)
						(localproc_0 20 4) ; "Hi, I'm Larry...Larry Laffer."
					)
					(1
						(localproc_0 20 5) ; "Know any places where cute girls hang out?"
						(= local16 1)
					)
					(2
						(localproc_0 20 6) ; "Do you see that cute blond over there? What a knockout!"
					)
					(3
						(localproc_0 20 7) ; "I'm starring in a new movie...called 'Looking for Love In Several Wrong Places.' You should check it out!"
					)
					(4
						(localproc_0 20 8) ; "Do you know when the bus to Coarsegold will arrive?"
						(= local16 2)
					)
					(5
						(localproc_0 20 9) ; "If you get a chance, call my producers at Sierra and tell them I might be a little late."
						(localproc_0 20 10) ; "Say that I've run into woman troubles, and I'm tied up right now."
						(localproc_0 20 11) ; "Thanks."
					)
				)
				(if (< local4 5)
					(++ local4)
				else
					(= local4 0)
				)
			)
			((Said 'yes')
				(switch local16
					(1
						(localproc_0 20 12) ; "Well, next time I'm in town we should get down and party!"
					)
					(2
						(localproc_0 20 13) ; "Good. I hope it comes soon. The producer and director will be really upset if I don't get to Coarsegold soon."
					)
					(else
						(event claimed: 0)
					)
				)
				(= local16 0)
			)
			((Said 'no')
				(switch local16
					(1
						(localproc_0 20 14) ; "Well don't feel bad, 'cause I don't either."
					)
					(2
						(localproc_0 20 15) ; "Well, I hope it comes soon."
					)
					(else
						(event claimed: 0)
					)
				)
				(= local16 0)
			)
		)
	)
)

(instance larryActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 20 40))
			)
			(1
				(switch (Random 0 1)
					(0
						(larry setLoop: 4 setCycle: End)
					)
					(1
						(larry setLoop: 3 setCycle: End)
					)
				)
				(= cycles (Random 40 60))
			)
			(2
				(larry setCycle: Beg)
				(self changeState: 0)
			)
		)
	)
)

(instance guard of Act
	(properties)
)

(instance manStanding of Prop
	(properties)
)

(instance rm20 of Rm
	(properties
		picture 20
		style 8
	)

	(method (dispose)
		(manScript dispose:)
		(keithScript dispose:)
		(guardScript dispose:)
		(gFeatures eachElementDo: #dispose 84)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 77)
		(Load rsVIEW 31)
		(Load rsVIEW 76)
		(super init:)
		(= gPerspective 70)
		(= global212 3)
		(= global211 1)
		(User canInput: 1)
		(if (or (not (IsFlag 40)) (!= gPrevRoomNum 40))
			(= local2 1)
		)
		(if (and (gEgo has: 16) (IsFlag 40)) ; plane_ticket
			(= local2 2)
		)
		(if (== gPrevRoomNum 40)
			(= local2 3)
			(SetFlag 40)
		)
		(if (and (== gPrevRoomNum 17) (not (gEgo has: 16))) ; plane_ticket
			(= local2 0)
		)
		(guard
			view: 31
			posn: 128 133
			loop: 0
			cel: 1
			init:
			brTop: 131
			brBottom: 133
		)
		((View new:)
			view: 81
			posn: 208 96
			loop: 0
			cel: 0
			setPri: 1
			init:
			addToPic:
		)
		((View new:)
			view: 81
			posn: 188 125
			loop: 2
			cel: 0
			setPri: 1
			init:
			addToPic:
		)
		((View new:)
			view: 81
			posn: 211 125
			loop: 2
			cel: 1
			setPri: 1
			init:
			addToPic:
		)
		(manStanding view: 81 posn: 92 140 loop: 1 cel: 0 init: stopUpd:)
		(larry init:)
		(self setLocales: 153)
		(self setScript: rm20Script)
	)
)

(instance rm20Script of Script
	(properties)

	(method (doit)
		(if (and (< (gEgo x:) 12) (not local5))
			(switch local2
				(0
					(localproc_0 20 16) ; "The door to the plane is closed because there IS no plane!"
					(gEgo setMotion: MoveTo 110 124)
				)
				(1
					(localproc_0 20 17) ; "The flight just departed. You missed it. Too bad!"
					(gEgo setMotion: MoveTo 110 124)
				)
				(2
					(if (not local14)
						(= local14 1)
						(boardingScript changeState: 0)
					)
				)
				(3
					(boardingScript changeState: 5)
				)
			)
		)
		(cond
			((and (not (gCast contains: global112)) (IsFlag 40) local8)
				(keithScript changeState: 0)
			)
			((and (== (gEgo onControl: 1) 4096) (not local17))
				(= local17 1)
				(if (!= gPrevRoomNum 17)
					(self changeState: 4)
				else
					(self changeState: 5)
				)
			)
		)
		(cond
			((> local0 1)
				(-- local0)
			)
			((== local0 1)
				(= local0 0)
				(manScript cue:)
			)
		)
		(if (and (> (gEgo y:) 127) (> (gEgo x:) 104))
			(= local5 1)
		else
			(= local5 0)
		)
		(cond
			((and (not local7) local8 (== (gEgo onControl: 1) 16384))
				(localproc_0 20 18) ; "Whoops! You almost had a nasty tumble when you tried to go down the 'Up' escalator."
				(= local7 1)
			)
			((and local7 (!= (gEgo onControl: 1) 16384))
				(= local7 0)
			)
		)
		(cond
			((<= (gEgo y:) 140)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(if
			(and
				(== (gEgo onControl: 1) 8192)
				(== (gEgo loop:) 3)
				(not local6)
				(or local9 (!= gPrevRoomNum 17) (not (gEgo has: 0))) ; hand_gun
			)
			(= local6 1)
			(if (and (> (++ local18) 2) (== (mod local18 2) 0))
				(localproc_0 20 19) ; "The guard says: "I'm gettin' dizzy watchin' you go in and out of this gate, mac.""
			)
		)
		(if (and local6 (!= (gEgo onControl: 1) 8192))
			(= local6 0)
		)
		(if
			(and
				(== (gEgo onControl: 1) 8192)
				(== (gEgo loop:) 3)
				(not local9)
				(== gPrevRoomNum 17)
			)
			(cond
				((not local10)
					(guardScript changeState: 3)
				)
				(local11
					(cond
						((gEgo has: 0) ; hand_gun
							(guardScript changeState: 10)
						)
						((< local18 3)
							(localproc_0 20 20) ; "You pass through the metal detector without setting off the alarm."
						)
					)
				)
			)
		)
		(if local13
			(guardScript changeState: 18)
		)
		(if (and global204 (not local15) (gEgo inRect: 105 132 168 168))
			(guardScript changeState: 21)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(if (== gPrevRoomNum 17)
					(HandsOff)
					(gEgo
						view: 1
						posn: 197 210
						init:
						setLoop: 2
						setCel: 1
						setCycle: 0
						setPri: 11
						illegalBits: 0
						setMotion: MoveTo 208 161 self
					)
				else
					(gEgo
						view: 1
						posn: 15 124
						init:
						setMotion: MoveTo 153 124
					)
					((= global112 (Act new:))
						view: 20
						setCycle: Walk
						posn: 24 124
						init:
					)
					(= local8 1)
					(keithScript changeState: 8)
					(SetFlag 40)
				)
			)
			(1
				(gEgo
					setLoop: -1
					setCel: -1
					setPri: -1
					setCycle: Walk
					xStep: 3
					yStep: 2
					setMotion: MoveTo 210 169
					startUpd:
				)
				(NormalEgo)
				(if (IsFlag 40)
					(self cue:)
				else
					(HandsOn)
				)
			)
			(2
				(gEgo setMotion: MoveTo 238 167 self)
			)
			(3
				(gEgo illegalBits: 0 setLoop: 1)
				(= local8 1)
			)
			(4
				(gEgo setMotion: 0)
				(localproc_0 20 21 83) ; "Keith sees You leaving and says: "Hey, Sonny! Wait for me!""
				(global112
					ignoreActors: 0
					setLoop: -1
					setMotion: MoveTo 158 133 self
				)
			)
			(5
				(HandsOff)
				(if (gCast contains: global112)
					(global112 setMotion: MoveTo 158 170)
				)
				(gEgo
					setLoop: 3
					setCel: 0
					setPri: 11
					setMotion: MoveTo (- (gEgo x:) 20) 204 self
					init:
					ignoreActors:
					illegalBits: 0
				)
			)
			(6
				(if (gCast contains: global112)
					(if (== gPrevRoomNum 17)
						(keithScript changeState: 4)
					else
						(global112 setMotion: MoveTo 250 170)
						(= gPerspective 0)
						(gCurRoom newRoom: 17)
					)
				else
					(= gPerspective 0)
					(gCurRoom newRoom: 17)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,chamber,gate]')
								(if local5
									(localproc_0 20 22) ; "The boarding and receiving area is equipped with a metal detector. A security guard mans his post."
								else
									(localproc_0 20 23) ; "You're in the connecting tunnel between the gate and the plane. Out the window you see just how busy Lytton Airport has become."
								)
							)
							((Said '/pane')
								(if (< (gEgo x:) 150)
									(localproc_0 20 24) ; "You gaze out across the runway and think of places far away."
								else
									(localproc_0 20 25) ; "You look out past the parking lot, and see the city in the distance."
								)
							)
							((or (Said '<up') (Said '/ceiling'))
								(localproc_0 20 26) ; "Looks solid enough. Probably won't cave in."
							)
							((or (Said '<down') (Said '/floor'))
								(localproc_0 20 27) ; "The carpet really needs cleaning. The gum chewers seem to have been having a field day."
							)
							((Said '/bench')
								(if local5
									(localproc_0 20 28) ; "The chairs are for the comfort of the waiting passengers, even though they appear to be made deliberately uncomfortable."
								else
									(localproc_0 20 29) ; "They don't put chairs in places like this."
								)
							)
							((Said '/painting')
								(if
									(and
										(< (gEgo y:) 140)
										(> (gEgo x:) 140)
										local5
									)
									(localproc_0 20 30) ; "The painting reminds you of a place you would like to be."
								else
									(localproc_0 20 31) ; "You have to be closer to see the painting clearly."
								)
							)
							((Said '/rope')
								(if (and (< (gEgo x:) 150) local5)
									(localproc_0 20 32) ; "It's a velveteen braided rope similar to the ones found in some movie theaters."
								else
									(localproc_0 20 33) ; "You're too far away."
								)
							)
							((Said '/wall')
								(localproc_0 20 34) ; "The pale blue paint is a nice touch. There is a painting on the wall behind the three gentlemen."
							)
							((Said '/guard')
								(localproc_0 20 35) ; "The rotund guard doesn't look like he is having fun."
							)
							((Said '/escalator')
								(if local5
									(localproc_0 20 36) ; "Nothing unusual about it. You ride up one side, and down the other."
								else
									(localproc_0 20 37) ; "Get out of the tunnel and you can see it."
								)
							)
							((Said '/woman,woman,blonde')
								(if (<= (gEgo y:) 137)
									(localproc_0 20 38) ; "Huh??"
								else
									(localproc_0 20 39) ; "The long-haired blonde looks pretty interesting."
								)
							)
							((Said '/men,crowd,passenger')
								(localproc_0 20 40) ; "A motley-looking crew of passengers waits for a flight."
							)
							((Said '/man,person')
								(cond
									((gEgo inRect: 160 124 200 135)
										(localproc_0 20 41) ; "This man looks bored."
									)
									((gEgo inRect: 200 124 222 135)
										(localproc_0 20 42) ; "This man looks very bored."
									)
									((gEgo inRect: 108 128 163 147)
										(localproc_0 20 35) ; "The rotund guard doesn't look like he is having fun."
									)
									((gEgo inRect: 83 128 115 136)
										(localproc_0 20 43) ; "Groovy!"
									)
									(else
										(localproc_0 20 44) ; "You look at no one in particular."
									)
								)
							)
						)
					)
					((Said 'sat[<down][/bench]')
						(localproc_0 20 45) ; "There is no place to sit."
					)
					((Said 'move,get/painting')
						(localproc_0 20 46) ; "Sorry! It's bolted to the wall."
					)
					((Said 'move,remove,break,cut,hoist,get/rope')
						(if (and (< (gEgo x:) 150) local5)
							(localproc_0 20 47) ; "That's totally unnecessary! Just walk through the metal detector."
						else
							(localproc_0 20 33) ; "You're too far away."
						)
					)
					((Said 'show,flash/badge')
						(if (gEgo has: 7) ; wallet
							(if local5
								(cond
									((gEgo inRect: 222 124 265 135)
										(localproc_0 20 2) ; "I didn't do it! She made me!"
									)
									((gEgo inRect: 163 124 221 135)
										(switch (Random 0 3)
											(0
												(localproc_0 20 48) ; "Who do you think you are....Don Johnson? What's your story?"
											)
											(1
												(localproc_0 20 49) ; "Boy! I've never seen a shinier badge!"
											)
											(2
												(localproc_0 20 50) ; "I'm gonna plead the fifth amendment."
											)
											(3
												(localproc_0 20 51) ; "Gee! You're a real cop!"
											)
										)
									)
									((gEgo inRect: 83 128 115 136)
										(localproc_0 20 52) ; "The long-haired blonde says, "Hey, man! Why don't you flash your badge on someone who cares.""
									)
									((gCast contains: local12)
										(= local9 1)
										(SetScore 2 98)
									)
									((gEgo inRect: 108 128 163 147)
										(if (not local9)
											(= local9 1)
											(SetScore 2 98)
											(= local10 1)
											(guardScript changeState: 0)
										else
											(localproc_0 20 53) ; "OK, Bonds! I SAW your badge! I KNOW you're a cop!"
										)
									)
									(else
										(localproc_0 20 54) ; "Nobody can see your badge right now."
									)
								)
							else
								(localproc_0 20 54) ; "Nobody can see your badge right now."
							)
						else
							(localproc_0 20 3) ; "You don't have your identification with you."
						)
					)
					((Said 'show/mugshot,painting,[shot<mug]')
						(if
							(and
								(not (gEgo has: 12)) ; new_mug_shot
								(not (gEgo has: 23)) ; old_mug_shot
							)
							(localproc_0 20 55) ; "You don't have it."
						else
							(localproc_0 20 56) ; "Nobody recognizes Bains' picture."
						)
					)
					((or (Said 'draw,pull,use,show/9mm') (Said 'fire,kill'))
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							((not (gEgo inRect: 108 128 163 147))
								(localproc_0 20 57) ; "What for??"
							)
							(
								(and
									(>= (guardScript state:) 14)
									(<= (guardScript state:) 17)
								)
								(localproc_0 20 58) ; "Not now while he's frisking you."
							)
							(else
								(localproc_0 20 59 25 4) ; "Uh-oh! Perhaps now is not a good time (and here is not a good place) to be taking your gun out."
								(guardScript changeState: 21)
							)
						)
					)
					((Said 'talk>')
						(cond
							((Said '/woman,woman,blonde')
								(if (gEgo inRect: 60 140 120 165)
									(if (not local3)
										(manScript changeState: 0)
									)
								else
									(localproc_0 20 38) ; "Huh??"
								)
							)
							((Said '/guard,cop')
								(if (gEgo inRect: 108 128 163 147)
									(localproc_0 20 60) ; "He doesn't seem real talkative."
								else
									(localproc_0 20 61) ; "He can't hear you at this distance."
								)
							)
							((Said '/man')
								(cond
									((gEgo inRect: 160 124 200 135)
										(localproc_0 20 62) ; "He doesn't say anything, and he's not Larry."
									)
									((gEgo inRect: 200 124 222 135)
										(localproc_0 20 63) ; "Airports are such a drag, especially sitting next to this guy here (referring to the man in white)."
									)
									((gEgo inRect: 83 128 115 136)
										(localproc_0 20 64) ; "The long-haired blonde says, "What's your trip, man?""
									)
									((gEgo inRect: 60 140 120 165)
										(localproc_0 20 65) ; "You hear a high-pitched voice say "Huh?""
									)
									((gEgo inRect: 108 128 163 147)
										(localproc_0 20 66) ; "Hello. Have a nice day."
									)
									(else
										(localproc_0 20 67) ; "There is no one close enough to talk to."
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance manScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theBlonde init: play:)
				(manStanding cel: 1 forceUpd:)
				(= local3 1)
				(= local0 20)
			)
			(1
				(localproc_0 20 68) ; "The guy turns around and says, "What's the matter with you, bud?""
				(= local0 20)
			)
			(2
				(manStanding cel: 0 forceUpd:)
				(= local3 0)
			)
		)
	)
)

(instance keithScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= global112 (Act new:))
					view: 20
					setCycle: Fwd
					setLoop: 2
					setCel: 1
					xStep: 3
					yStep: 2
					ignoreActors: 0
					posn: 206 204
					setPri: 11
					setMotion: MoveTo 204 161 self
					init:
					illegalBits: 0
				)
			)
			(1
				(global112
					setPri: -1
					setLoop: -1
					setCel: -1
					setCycle: Walk
					ignoreActors: 0
					illegalBits: $a000
					setMotion: MoveTo 204 164 self
				)
				(gEgo illegalBits: $8000 setLoop: -1)
			)
			(2
				(HandsOn)
				(global112 setMotion: MoveTo 111 168 self)
			)
			(3
				(global112 loop: 0)
			)
			(4
				(global112
					ignoreActors: 0
					setPri: -1
					setMotion: MoveTo 260 165 self
				)
			)
			(5
				(global112 setMotion: MoveTo 260 162 self)
			)
			(6
				(global112
					setLoop: 3
					setCel: 0
					setPri: 11
					setMotion: MoveTo (- (global112 x:) 20) 204 self
					init:
					ignoreActors:
					illegalBits: 0
				)
			)
			(7
				(= gPerspective 0)
				(gCurRoom newRoom: 17)
			)
			(8
				(global112 setMotion: MoveTo 132 124 self)
			)
			(9
				(global112 setMotion: MoveTo 150 132 self)
			)
			(10
				(global112 setMotion: MoveTo 198 134 self)
			)
			(11
				(global112 loop: 1 cel: 1)
			)
		)
	)
)

(instance guardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(guard ignoreActors: 0 setMotion: MoveTo 128 133 self)
			)
			(1
				(guard loop: 2 cel: 1)
				(RedrawCast)
				(self cue:)
			)
			(2
				(localproc_0 20 69) ; "You show your badge, and the security guard says... "Pass right on through, Officer. Just remember...no partaking of the spirits.""
				(guard loop: 0)
				(RedrawCast)
				(User canControl: 1)
			)
			(3
				(= local10 1)
				(HandsOff)
				(gEgo setMotion: 0)
				(if (gEgo has: 0) ; hand_gun
					(localproc_0 20 70 25 4) ; "As you walk into the magnetic field, your gun sets off an alarm."
				else
					(localproc_0 20 71 25 4) ; "As you walk into the magnetic field, something sets off an alarm."
				)
				(guard setCycle: Walk setMotion: MoveTo 140 133 self)
			)
			(4
				(guard setMotion: MoveTo 149 133 self)
			)
			(5
				(guard loop: 2 cel: 4)
				(self cue:)
			)
			(6
				(localproc_0 20 72 25 5 83) ; "One minute, sir!" the portly security guard says. "Please empty your pockets and walk through the detector again."
				(gEgo setMotion: MoveTo 155 144 self)
			)
			(7
				(gEgo setMotion: MoveTo 138 144)
				(guard setMotion: MoveTo 128 133 self)
			)
			(8
				(gEgo cel: 6)
				(guard loop: 0 cel: 1)
				(self cue:)
			)
			(9
				(HandsOn)
				(= local11 1)
				(localproc_0 20 73 25 4 83) ; "You remove everything from your pockets and try it again."
			)
			(10
				(HandsOff)
				(= local11 0)
				(User canControl: 0)
				(localproc_0 20 74 25 4) ; "Walking through the detector, your gun again sets off the alarm."
				(localproc_0 20 75 25 4) ; "Getting serious, the security guard says..."Hey, Mac! Are you packing a gun or something?""
				(self cue:)
			)
			(11
				(gEgo illegalBits: 0 setMotion: MoveTo 162 134 self)
			)
			(12
				(gEgo illegalBits: $8000 loop: 1 cel: 7)
				(guard loop: 6 cel: 0 setCycle: End self)
			)
			(13
				(localproc_0 20 76 25 4 83) ; ""Freeze right where you are, fella!" orders the guard."
				(self cue:)
			)
			(14
				(guard
					setLoop: 7
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 153 133 self
				)
			)
			(15
				(guard cel: 0)
				(self cue:)
			)
			(16
				(gEgo hide:)
				(guard hide:)
				((= local12 (Prop new:))
					view: 31
					loop: 8
					cel: 0
					posn: 157 134
					init:
					startUpd:
					cycleSpeed: 3
					setCycle: End self
				)
				(User canInput: 1)
			)
			(17
				(localproc_0 20 77 25 4 83) ; "The guard pats you down, finds and removes your gun, and says to you..."
				(if local9
					(localproc_0 20 78) ; "The next time you're packin' iron, and you want to pass through a metal detector, think about identifying yourself."
					(HandsOn)
					(= local13 1)
				else
					(localproc_0 20 79) ; ""Okay, you pistol-packin' dude. You're under arrest!"
					(EgoDead
						{As you have just discovered, you have to use your head if you're a cop. You didn't, and now this guy's going to arrest YOU!}
					)
				)
			)
			(18
				(= local13 0)
				(local12 dispose:)
				(guard ignoreActors: 0 show:)
				(gEgo illegalBits: $8000 posn: 162 134 show:)
				(self cue:)
			)
			(19
				(guard setLoop: 1 setCycle: Walk setMotion: MoveTo 128 133 self)
			)
			(20
				(guard setLoop: 0)
				(User canControl: 1)
				(localproc_0 20 80 25 4 83) ; "OK, Mr. Homicide Detective Bonds...go ahead with your business."
			)
			(21
				(= local15 1)
				(guard setCycle: Walk setMotion: MoveTo 151 133 self)
			)
			(22
				(guard setLoop: 4 setCycle: End self)
			)
			(23
				(guard setLoop: 5 setCycle: End self)
			)
			(24
				(gEgo hide:)
				((View new:)
					view: 76
					loop: 7
					cel: 0
					posn: 147 155
					init:
					ignoreActors:
					addToPic:
				)
				(Print 20 81 #at -1 116 #draw) ; "You draw your weapon just as the guard goes for his. Being in fear of his life, the security guard blows you into eternity."
				(self cue:)
			)
			(25
				(EgoDead
					{Nobody ever figured out why Sonny Bonds tried to draw down on an airport security guard, but the results were obviously disastrous.}
				)
			)
		)
	)
)

(instance boardingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 20 82 25 5 83) ; "The flight attendant at the entrance to the airplane asks you for your ticket."
				(global112
					illegalBits: 0
					ignoreActors:
					startUpd:
					setLoop: 0
					setMotion: MoveTo 155 139 self
				)
				(gEgo put: 16 16) ; plane_ticket
			)
			(1
				(localproc_0 20 83 83) ; "You hand your ticket to the attendant as you board the plane."
				(global112 setLoop: 1)
				(self cue:)
			)
			(2
				(localproc_0 20 84 83) ; "Keith flashes his badge at the security guard and hollers: "Hey, Sonny! I'm right behind you!""
				(global112 setLoop: 3 setMotion: MoveTo 155 124 self)
			)
			(3
				(global112 setLoop: 1 setMotion: MoveTo -5 124 self)
			)
			(4
				(HandsOn)
				(if (== global195 1)
					(= global100 14)
				else
					(SetFlag 166)
				)
				(= gPerspective 0)
				(gCurRoom newRoom: 40)
			)
			(5
				(localproc_0 20 85) ; "Have a nice day!"
				(gEgo setMotion: MoveTo 110 124)
			)
		)
	)
)

