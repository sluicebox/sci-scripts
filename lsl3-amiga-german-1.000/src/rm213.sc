;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm213 0
)

(local
	seenMsg
	havePaper
)

(instance rm213 of Rm
	(properties
		picture 213
		horizon 5
		east 210
	)

	(method (init)
		(super init:)
		(if (TestFlag 15)
			(= gNewspaperState 2)
		)
		(if gNewspaperState
			(aNewspaper init:)
		)
		(aRiver init:)
		(aRiver2 init:)
		(aTv init:)
		(self setScript: RoomScript)
		(if (not (TestFlag 26))
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(gEgo posn: 314 163)
		(NormalEgo)
		(gEgo init:)
		(gSoundFX number: 213 loop: -1 play:)
	)

	(method (newRoom newRoomNumber)
		(gMusic fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'open,activate,(pull<on)/camera,drop,drop')
				(cond
					((not (gEgo inRect: 134 125 164 131))
						(NotClose) ; "You're not close enough."
					)
					((< (aTv y:) 200)
						(ItIs) ; "It is."
					)
					(else
						(Ok) ; "O.K."
						(aTv posn: 148 116)
					)
				)
			)
			((Said 'close,deactivate,(pull<off)/camera,drop,drop')
				(cond
					((not (gEgo inRect: 134 125 164 131))
						(NotClose) ; "You're not close enough."
					)
					((> (aTv y:) 200)
						(ItIs) ; "It is."
					)
					(else
						(Ok) ; "O.K."
						(aTv posn: 148 1116)
					)
				)
			)
			((Said 'lie')
				(cond
					(gEgoIsPatti
						(Print 213 0) ; "You don't need to do that."
					)
					((== gEgoState 1004)
						(YouAre) ; "You are."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Ok) ; "O.K."
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said
						'rise,(get,get<off),(get,get<up),(rise,nightstand<up)'
					)
					(Said 'exit/barstool')
				)
				(cond
					((== gEgoState 0)
						(YouAre) ; "You are."
					)
					((!= gEgoState 1004)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 9)
					)
				)
			)
			((Said 'swim')
				(Print 213 1) ; "Not in that stream! Have you looked carefully at that water?"
			)
			((Said 'pull,alter,alter/channel')
				(if (< (aTv y:) 200)
					(Print 213 2) ; "There's only one channel and it's owned by Natives, Inc.!"
				else
					(Print 213 3) ; "That won't do much good. It's off!"
				)
			)
			((Said 'open,activate,(pull<on)/burn,burn')
				(Print 213 4) ; "They are!"
			)
			((Said 'close,deactivate,(pull<off)/burn,burn')
				(Print 213 5) ; "You can't do that here; at least, not now."
			)
			((Said 'caress,look,look<below,back,back,behind/buffet')
				(Print 213 6) ; "Congratulations!"
				(Print 213 7) ; "You've found..."
				(Print 213 8) ; "...nothing!"
			)
			((Said 'look,look,caress<below/barstool')
				(Print 213 9) ; "You find some fresh, wet bubble gum, but nothing that you'd care to keep!"
			)
			((or (Said '//camera,drop,drop>') (Said '/camera,drop,drop>'))
				(cond
					((Said 'watch,armbanduhr')
						(if (< (aTv y:) 200)
							(Print 213 10) ; "Too bad this island doesn't have cable."
						else
							(Print 213 11) ; "You stare at the screen, blankly."
						)
					)
					((Said 'look,look')
						(if (< (aTv y:) 200)
							(Print 213 10) ; "Too bad this island doesn't have cable."
						else
							(Print 213 12) ; "It looks like it MIGHT work."
						)
					)
					((Said 'adjust')
						(Print 213 13) ; "You can't. Just enjoy it as it is!"
					)
					((Said 'get,get')
						(Print 213 14) ; "You're not strong enough to carry it."
					)
					((Said 'caress,look,look<back,back,below,behind')
						(if (< (aTv y:) 200)
							(Print 213 15) ; "OOOOOOWWWWWWWWW!!!!!!!!!"
							(Print 213 16 #at -1 144) ; "(Don't you know better than to mess around the back of a television set when it's on!)"
							(gGame changeScore: -1)
						else
							(Print 213 17) ; "There's nothing back there but air."
						)
					)
					(else
						(Print 213 18) ; "Isn't it strange to find a television in a park?"
					)
				)
			)
			((Said 'get,get/buffet')
				(Printf 213 19 gEgoName gEgoName) ; "You're after things with TWO legs, %s."
			)
			((Said 'get,get/burn,burn')
				(Print 213 20) ; "Leave the lights alone."
			)
			((Said 'look,look/barstool')
				(if (== gEgoState 1004)
					(Print 213 21) ; "Its slats make indentations on your butt."
				else
					(Print 213 22) ; "It's in need of a paint job."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/burn,burn')
						(Printf 213 23 gEgoName gEgoName) ; "They just hang around -- rather like you, %s!"
					)
					((Said '/buffet')
						(cond
							(havePaper
								(Print 213 24) ; "Its polyvinyl chloride surface glistens beneath these lights!"
							)
							((gCast contains: aNewspaper)
								(Print 213 25) ; "There is a newspaper lying on the table."
							)
							(else
								(Print 213 26) ; "It's just a simple end table."
							)
						)
					)
					((Said '/creek,cascade,water')
						(Print 213 27) ; "How nice. Natives, Inc. has created a lovely waterfall using the untreated effluent of their sewage."
					)
					((Said '/carpet')
						(Print 213 28) ; "These flagstones were made by short, fat, white guys in plaid shirts."
					)
					((Said '[/area]')
						(Print 213 29) ; "What an interesting park! A lovely television set sits beneath attractive hanging lamps facing a park bench -- all situated near a gurgling stream."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= cycles (= seconds 0))
				(HandsOff)
				(cond
					((> (gEgo y:) 171)
						(gEgo setMotion: MoveTo (gEgo x:) 171 self)
					)
					((< (gEgo y:) 126)
						(gEgo setMotion: MoveTo (gEgo x:) 126 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(cond
					((> (gEgo x:) 171)
						(gEgo setMotion: MoveTo 171 (gEgo y:) self)
					)
					((< (gEgo x:) 122)
						(gEgo setMotion: MoveTo 122 (gEgo y:) self)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 171 self)
			)
			(4
				(= cycles (= seconds 0))
				(gEgo view: 214 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(gUser canInput: 1)
				(= gEgoState 1004)
				(if (== havePaper 1)
					(= seconds 3)
				)
			)
			(6
				(gEgo setCel: 0 loop: 1)
				(= seconds (Random 1 4))
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(gEgo setCycle: Beg self)
				(= state 5)
			)
			(9
				(HandsOff)
				(= cycles (= seconds 0))
				(if havePaper
					(Print 213 30) ; "You return the newspaper to the table."
					(= havePaper 0)
					(aNewspaper posn: 198 190)
				)
				(gEgo view: 214 setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(10
				(NormalEgo 3)
				(= gEgoState 0)
			)
			(11
				(= seconds 0)
			)
		)
	)
)

(instance aTv of Prop
	(properties
		x 148
		y 1116
		view 213
		loop 1
		priority 4
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance aRiver of Prop
	(properties
		x 31
		y 104
		view 213
		loop 2
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aRiver2 of Prop
	(properties
		y 141
		view 213
		loop 3
		cel 1
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aNewspaper of View
	(properties
		x 198
		y 190
		view 213
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 15 z: (- (aNewspaper y:) 169))
	)

	(method (handleEvent event)
		(if
			(or
				(!= (event type:) evSAID)
				(event claimed:)
				(not (Said '/document>'))
			)
			(return)
		)
		(if (Said 'get,get')
			(cond
				(gEgoIsPatti
					(Print 213 31) ; "You don't have time to read, Patti!"
				)
				(havePaper
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 170 161 221 187))
					(NotClose) ; "You're not close enough."
				)
				((and (!= gEgoState 0) (!= gEgoState 1004))
					(NotNow) ; "Good idea. You might try that again later."
				)
				(else
					(Ok) ; "O.K."
					(aNewspaper posn: 198 1190)
					(= havePaper 1)
					(if (== gEgoState 1004)
						(RoomScript changeState: 5)
					else
						(RoomScript changeState: 1)
					)
				)
			)
		)
		(if (Said 'drop,drop,drop,close')
			(if (not havePaper)
				(DontHave) ; "You don't have it."
			else
				(Ok) ; "O.K."
				(= havePaper 0)
				(aNewspaper posn: 198 190)
				(gEgo view: 214 setLoop: 0 setCel: 255)
				(RoomScript cycles: 0 seconds: 0 changeState: 5)
			)
		)
		(if (Said 'look,look')
			(if (not havePaper)
				(DontHave) ; "You don't have it."
			else
				(switch gNewspaperState
					(2
						(Print 213 32) ; "Scanning through the island newspaper, you find an advertisement for the Casino Lounge..."
						(Print 213 33 #font gBigFont #mode 1 #at -1 30 #width 234) ; "Coming Soon! Here! At our own Lounge and Piano Bar! Passionate Patti at the Keyboard. Watch for her -- you won't regret it!"
					)
					(1
						(Print 213 34) ; "Reading the island newspaper, you find an advertisement for the Casino Showroom..."
						(Print 213 35 #font gBigFont #mode 1 #at -1 30 #width 234) ; "Now Playing! The big, new, all-girl revue! It's got T's! It's got A's! It's got prerecorded music! It's the latest and greatest show from producer Irving Guice!"
					)
					(3
						(Print 213 36 #font gBigFont #mode 1 #at -1 30 #width 234) ; "Now appearing in the Casino Lounge: Passionate Patti! Keyboard and Sing-A-Long Star Of Five Continents! Even Appeared On `Star Search'"
					)
					(else
						(Print 213 37) ; "Headless Corpse Found in Topless Bar"
						(Print 213 38 #at -1 144) ; "(Don't you just love yellow journalism?!)"
					)
				)
			)
		)
	)
)

(instance aCredit1 of Prop
	(properties
		x 288
		y 131
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 215 904))
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		x 288
		y 154
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 215 904))
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(SetFlag 26)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

