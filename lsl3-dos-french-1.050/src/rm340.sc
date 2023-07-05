;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	[local0 45]
	local45
	local46
	local47
	local48
	[local49 50]
	[local99 20]
	[local119 20]
	[local139 20]
	local159
	local160
	local161
	[local162 500]
)

(instance rm340 of Rm
	(properties
		picture 340
		horizon 1
		south 240
	)

	(method (init)
		(Load rsTEXT 341)
		(Load rsVIEW 705)
		(Load rsVIEW 344)
		(LoadMany rsSOUND 21 22 23 24 25 26 27 10 340 341)
		(= gEgoState 16)
		(super init:)
		(gAddToPics
			add: atpChair
			add: atpManUR
			add: atpManLR
			add: atpManUL_Bottom
			add: atpLadyLR_Bottom
			add: atpLadyUL_Bottom
			doit:
		)
		(aManUL_Top init:)
		(aLadyUL_Top init:)
		(aLadyLR_Top init:)
		(aDrummer init:)
		(aComic init:)
		(aSign init:)
		(if (and (InRoom 13) (gEgo has: 12)) ; Penthouse_Key
			(aBottle setPri: 10 ignoreActors: init:)
		)
		(self setScript: RoomScript)
		(NormalEgo 3 (+ 705 gEgoIsHunk))
		(gEgo posn: 159 188 init:)
		(if (TestFlag 13)
			(aAl loop: 5 cel: 4 init: stopUpd:)
			(aBill loop: 4 cel: 4 init: stopUpd:)
		else
			(aAlTop init:)
			(aBillTop init:)
			(aAl init:)
			(aBill init:)
		)
	)

	(method (newRoom newRoomNumber)
		(if local48
			(Print 340 0) ; "Hey, you!" shouts the comic. "Come back when you get a sense of humor!"
		)
		(= gEgoState 0)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'boo')
				(if local48
					(Print 340 1) ; "Hey, Paul," you shout, "that joke's so old it's got gray hair!"
					(Printf 340 2 global304 global305) ; ""Oh, yeah," retorts the comic, "%s"%"
					(Print 340 3 #at -1 144) ; "(Some guys just don't have a way with hecklers!)"
				else
					(Print 340 4) ; "Wait until the comic is onstage."
				)
			)
			((Said 'applaud')
				(if local48
					(Print 340 5) ; "Hey, Paul," you shout, "that last joke was mildly amusing!"
				else
					(Print 340 4) ; "Wait until the comic is onstage."
				)
			)
			((and gDebugging (Said 'test/joke'))
				(= local45 (GetNumber {First joke (from 1 to LAST JOKE):}))
				(Printf 340 6 local45 local45) ; "Ok. Next joke will be #%d.%"
			)
			((Said 'talk,talk/comedian')
				(if local48
					(Print 340 7) ; "Hey, buddy," you shout, "that material came over on the `Bounty!'"
				else
					(Print 340 8) ; "Paul's not here. He's successfully escaped again!"
				)
			)
			((Said 'talk,talk/bob')
				(Print 340 9) ; "Hey, Bob! Don't give up your day gig!"
			)
			(
				(or
					(Said 'get,get/microphone')
					(Said 'rise,nightstand,get,get,jump,climb<on/backstage')
				)
				(Print 340 10) ; "From the looks of your input, you're no comedian!"
			)
			((Said 'talk,talk/man,bill,woman,al')
				(if
					(or
						(& (gEgo onControl:) $0008)
						(& (gEgo onControl:) $0004)
					)
					(if (TestFlag 13)
						(Print 340 11) ; "Where?"
					else
						(self changeState: 6)
					)
				else
					(Printf 340 12 gEgoName gEgoName) ; "These people are here to hear the comedian, not you. Find a seat, %s, and enjoy yourself.%"
				)
			)
			((Said 'get,get/bottle,beer')
				(cond
					((and (!= gEgoState 16) (!= gEgoState 1004))
						(NotNow) ; "Good idea. You might try that again later."
					)
					((or (not (InRoom 13)) (not (gEgo has: 12))) ; Penthouse_Key
						(Print 340 11) ; "Where?"
					)
					((not (& (gEgo onControl:) $0080))
						(NotClose) ; "You're not close enough."
					)
					(else
						(Ok) ; "O.K."
						(aBottle dispose:)
						(gGame changeScore: 15)
						(Print 340 13) ; "You quietly cop some poor slob's bottle of `fine' wine."
						(gEgo get: 13) ; Bottle_of_Wine
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
					((== gEgoState 16)
						(YouAre) ; "You are."
					)
					((!= gEgoState 1004)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 4)
					)
				)
			)
			((Said 'lie')
				(cond
					((not (& (gEgo onControl:) $0002))
						(Print 340 14) ; "Move in front of the chair that's at the center table."
					)
					((== gEgoState 1004)
						(YouAre) ; "You are."
					)
					((!= gEgoState 16)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 1)
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/barstool')
						(Print 340 15) ; "The world-famous "Comedy Hut" has one empty table and chair, and it's right in the center of the room!"
					)
					((Said '/backstage')
						(Print 340 16) ; "The stage here is not too big, but it's dark!"
					)
					((Said '/mask')
						(Print 340 17) ; "One represents "Comedy," the second "Tragedy," and the third "Caffeine," but you can never remember which is which!"
					)
					((Said '/awning')
						(Print 340 18) ; "The sign is the most impressive aspect of this place!"
					)
					((Said '/cigarette,smoke')
						(Print 340 19) ; "There's always got to be someone!"
					)
					((Said '/burn,burn,burn')
						(Print 340 20) ; "The spotlight spotlights the stage."
					)
					(
						(or
							(Said 'buy,order/beer,drink,drink,beer')
							(Said 'buy,order//beer,drink,drink,beer')
							(Said '/attendant,attendant,attendant')
							(Said '//attendant,attendant,attendant')
						)
						(Print 340 21) ; "It's impossible to get a drink around here!"
					)
					((Said '/door')
						(Print 340 22) ; "The door to the outside is to the south."
					)
					((Said '/comedian')
						(if local48
							(Print 340 23) ; "Look! It's Paul Paul!"
						else
							(Print 340 24) ; "He's backstage, trying to rid himself of the odor of flop sweat!"
						)
					)
					((Said '/woman')
						(Print 340 25) ; "There are several women sitting here in the "Comedy Hut," but none that are interested in talking to you."
					)
					((Said '/man,couple')
						(if
							(and
								(not (TestFlag 13))
								(or
									(& (gEgo onControl:) $0008)
									(& (gEgo onControl:) $0004)
								)
							)
							(Print 340 26) ; "Sitting at this table are Bill Skirvin and Al Lowe, deep in an esoteric discussion about 3-D animated graphic adventure game design."
						else
							(Print 340 27) ; "There are several men sitting here in the "Comedy Hut," but none that are interested in talking to you."
						)
					)
					((Said '/bottle')
						(if (and (InRoom 13) (gEgo has: 12)) ; Penthouse_Key
							(Print 340 28) ; "A bottle of wine rests on the center table, breathing until its owner returns."
						else
							(Print 340 11) ; "Where?"
						)
					)
					((Said '/al')
						(cond
							((TestFlag 13)
								(Print 340 29) ; "He is not here."
								(Print 340 30 #at -1 144) ; "(He has "poofed!")"
							)
							((& (gEgo onControl:) $0008)
								(Print 340 31) ; "Al Lowe is trying (unsuccessfully) to make some point with Bill Skirvin."
							)
							(else
								(Print 340 32) ; "Hey! Is that Al Lowe over there?"
							)
						)
					)
					((Said '/bill')
						(cond
							((TestFlag 13)
								(event claimed: 0)
							)
							((& (gEgo onControl:) $0004)
								(Print 340 33) ; "William Skirvin is trying to explain the subtleties of computer graphics with Al Lowe."
							)
							(else
								(Print 340 34) ; "Hey! Is that Bill Skirvin over there?"
							)
						)
					)
					((Said '/buffet')
						(if
							(and
								(& (gEgo onControl:) $0080)
								(InRoom 13)
								(gEgo has: 12) ; Penthouse_Key
							)
							(Print 340 28) ; "A bottle of wine rests on the center table, breathing until its owner returns."
						else
							(Print 340 35) ; "The world-famous "Comedy Hut" is filled with tables, many of which have people sitting at them enjoying themselves. Why don't you sit at that empty table in the center of the room."
						)
					)
					((Said '/bob')
						(if local48
							(Print 340 36) ; "He always plays the same fill."
						else
							(Print 340 37) ; "He looks terminally bored."
						)
					)
					((Said '[/area,couple]')
						(Print 340 38) ; "The world-famous "Comedy Hut" is filled with people having a mildly uproarious time."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Ok) ; "O.K."
				(HandsOff)
				(if (< (gEgo x:) 165)
					(gEgo illegalBits: 0 setMotion: MoveTo 153 145 self)
					(= local47 4)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 176 145 self)
					(= local47 5)
				)
			)
			(2
				(= cycles (= seconds 0))
				(gEgo
					view: 705
					loop: local47
					cel: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(3
				(if (== (ComicScript state:) 0)
					(ComicScript changeState: 1)
				)
				(User canInput: 1)
				(= gEgoState 1004)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(= gEgoState 16)
				(NormalEgo 3 (+ 705 gEgoIsHunk))
				(if local48
					(Print 340 39) ; "Hey, you!" shouts the comic. "Don't you like my material?"
				)
			)
			(6
				(HandsOff)
				(= local49 0)
				(while (> 5 (StrLen @local49))
					(GetInput
						@local49
						50
						{Just say what you want to say:}
						80
						{Author Interface}
					)
				)
				(aAlTop loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(aAlTop loop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(Printf 340 40 @local49 @local49) ; ""Hey! I've got an idea. How about if you and I sit in a comedy club and we make Larry walk up to us and say something like, `%s'"%"
				(aAlTop loop: 2 setCel: 255 setCycle: Beg self)
			)
			(9
				(aBillTop show:)
				(= seconds 3)
			)
			(10
				(Printf 340 41 @local49 @local49) ; ""`%s', eh?" says Bill, "Are you crazy? No way. That's so lame! Larry would never say that!"%"
				(= seconds 3)
			)
			(11
				(aBillTop hide:)
				(aAlTop setCycle: End self)
			)
			(12
				(aAlTop loop: 3 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(Printf 340 42 @local49 @local49) ; ""Yeah, I suppose you're right," says Al. "This is not a good idea. Let's get out of here! `%s' Really!!"%"
				(aAl dispose:)
				(aBill dispose:)
				(aAlTop posn: 99 191 loop: 5 cel: 0 cycleSpeed: 1 setCycle: End)
				(aBillTop
					posn: 70 190
					loop: 4
					cel: 0
					cycleSpeed: 1
					show:
					setCycle: End self
				)
			)
			(14
				(HandsOn)
				(aAlTop stopUpd:)
				(aBillTop stopUpd:)
				(if (not (TestFlag 13))
					(SetFlag 13)
					(gGame changeScore: 5)
				)
			)
		)
	)
)

(instance ComicScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== -1 (gMusic prevSignal:)) (== state 7))
			(self cue:)
		)
	)

	(method (changeState newState &tmp [jokeString 500] [jokeArgs 4] count line i j k)
		(switch (= state newState)
			(0)
			(1
				(if (> gMachineSpeed 39)
					(aSign setCycle: Fwd)
				)
				(gMusic number: 10 loop: -1 play:)
				(aDrummer loop: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(Print 340 43) ; "And now, ladies and gentlemen, the world-famous `Comedy Hut' is proud to present, a legend in his own mind, Paul Paul!"
				(if (!= gEgoState 1004)
					(Print 340 44) ; "From the darkness, someone in the audience yells at you, "Hey you! Yeah, you standing up! Sit down, willya?""
				)
				(gMusic stop: number: 340 loop: 1 play:)
				(aDrummer cycleSpeed: 1 loop: 1)
				(= seconds 3)
			)
			(3
				(aComic setMotion: MoveTo 160 58 self)
			)
			(4
				(aComic setPri: -1 setMotion: MoveTo 160 78 self)
			)
			(5
				(if (> gMachineSpeed 39)
					(aSign setCel: 1 stopUpd:)
				)
				(= local48 1)
				(= seconds 3)
			)
			(6
				(aComic loop: 4 viewer: talkCycler)
				(= seconds 3)
			)
			(7)
			(8
				(aDrummer cycleSpeed: 0 loop: 0 setCel: 0)
				(Print 340 45) ; ""Good evening, ladies and germs," says Paul, always the snappy starter."
				(= seconds 3)
			)
			(9
				(gMusic number: 341 loop: -1 play:)
				(if (!= gEgoState 1004)
					(Print 340 46) ; "The comic looks straight at you. "Sit down, dork!""
				)
				(= local99 0)
				(= local119 0)
				(= local139 0)
				(if (== (gGame printLang:) 1)
					(Print 340 47) ; "Ok, folks, we're gonna try something different tonight. Tell me the name of your three favorite ethnic groups. It doesn't matter to me which you choose; I've got enough jokes to insult anyone!"
					(while (u> 3 (StrLen @local99))
						(GetInput @local99 15 {Ethnic group #1:})
					)
					(while (u> 3 (StrLen @local119))
						(GetInput @local119 15 {Ethnic group #2:})
					)
					(while (u> 3 (StrLen @local139))
						(GetInput @local139 15 {Ethnic group #3:})
					)
					(Print 340 48) ; "Thank you."
				else
					(Format @local99 340 49) ; "ethnicGroup1"
					(Format @local119 340 50) ; "ethnicGroup2"
					(Format @local139 340 51) ; "ethnicGroup3"
				)
				(= seconds 3)
			)
			(10
				(aComic loop: 4 viewer: talkCycler)
				(= seconds 3)
			)
			(11
				(aComic setCycle: Walk viewer: 0)
				(= count 0)
				(repeat
					(++ count)
					(= i (Random 0 42))
					(if local45
						(= i (++ local45))
						(= [local0 i] 0)
					)
					(if (== [local0 i] 0)
						(= [local0 i] 1)
						(= local160 (= local159 (Random 49 51)))
						(= local161 local159)
						(while (== local159 local160)
							(= local160 (Random 49 51))
						)
						(while
							(or (== local161 local159) (== local161 local160))
							(= local161 (Random 49 51))
						)
						(for ((= j 0)) (< j 6) ((++ j))
							(= k 0)
							(Format @jokeString 340 52 341 (+ j (* i 6))) ; "%s"
							(if (!= 32 (StrAt @jokeString 1))
								(for
									((= line 0))
									(< line (StrLen @jokeString))
									((++ line))
									
									(if (== 47 (StrAt @jokeString line))
										(StrAt @jokeString line 37)
										(switch (StrAt @jokeString (++ line))
											(local159
												(= [jokeArgs k] @local99)
												(++ k)
											)
											(local160
												(= [jokeArgs k] @local119)
												(++ k)
											)
											(local161
												(= [jokeArgs k] @local139)
												(++ k)
											)
										)
										(StrAt @jokeString line 115)
										(++ line)
									)
								)
								(Format
									@local162
									@jokeString
									[jokeArgs 0]
									[jokeArgs 1]
									[jokeArgs 2]
									[jokeArgs 3]
									[jokeArgs 4]
								)
								(SaveSubLang)
								(Print @local162)
								(RestoreSubLang)
							)
						)
						(if (> local45 42)
							(if local45
								(Print 340 53) ; "All done."
								(= local45 0)
							else
								(Print 340 54) ; "error"
							)
						)
						(aDrummer setCycle: End)
						(gSoundFX
							priority: 1
							number: (Random 21 27)
							loop: 1
							play:
						)
						(break)
					)
					(if (>= count 1000)
						(= state 12)
						(break)
					)
				)
				(= seconds 2)
			)
			(12
				(aComic setMotion: MoveTo (Random 125 195) (Random 66 80) self)
				(= state 9)
			)
			(13
				(gMusic fade:)
				(Print 340 55) ; "And now," says the comic, "because you've been so patient, I'd like to do my famous impersonation of a duck!"
				(aComic setMotion: MoveTo 158 75 self)
			)
			(14
				(Print 340 56) ; "And it goes something like this..."
				(if (not (TestFlag 43))
					(SetFlag 43)
					(gGame changeScore: 100)
				)
				(= seconds 2)
			)
			(15
				(aComic
					view: 344
					loop: 2
					cel: 0
					setCycle: End self
					setMotion: 0
				)
			)
			(16
				(aComic setCycle: Walk setMotion: MoveTo 125 75 self)
			)
			(17
				(aComic setMotion: MoveTo 194 75 self)
			)
			(18
				(aComic setMotion: MoveTo 161 75 self)
			)
			(19
				(aComic loop: 2 setCel: 255 setCycle: Beg self)
			)
			(20
				(aComic view: 343 loop: 2 setCycle: Walk)
				(= seconds 2)
			)
			(21
				(Print 340 57) ; "Ladies and gentlemen, Paul Paul!"
				(gMusic number: 340 loop: -1 play:)
				(if (> gMachineSpeed 39)
					(aSign setCycle: Fwd)
				)
				(= seconds 2)
			)
			(22
				(aComic setMotion: MoveTo 160 57 self)
			)
			(23
				(Print 340 58) ; "Look! He's getting a sitting ovation!"
				(aComic setMotion: MoveTo 241 58 self)
				(gMusic fade:)
				(= local48 0)
			)
			(24
				(aComic hide:)
				(if (> gMachineSpeed 39)
					(aSign setCel: 0 stopUpd:)
				)
				(aDrummer stopUpd:)
				(gMusic number: 341 loop: gBgMusicLoops play:)
			)
		)
	)
)

(instance drinkerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(switch (Random 1 3)
					(1
						(= local46 aLadyLR_Top)
					)
					(2
						(= local46 aLadyUL_Top)
					)
					(3
						(= local46 aManUL_Top)
					)
				)
				(local46 setCycle: End self)
			)
			(2
				(if (== local46 aLadyUL_Top)
					(= state -1)
				)
				(= cycles (Random 5 22))
			)
			(3
				(local46 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance atpManUR of PV
	(properties
		y 186
		x 247
		view 340
		cel 9
	)
)

(instance atpManLR of PV
	(properties
		y 128
		x 249
		view 340
		cel 8
	)
)

(instance atpChair of PV
	(properties
		y 145
		x 165
		view 340
		priority 11
	)
)

(instance aDrummer of Prop
	(properties
		y 71
		x 79
		view 345
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance aBottle of View
	(properties
		y 119
		x 165
		view 340
		cel 5
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aBillTop of Prop
	(properties
		y 155
		x 67
		view 346
		loop 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setPri: 14 ignoreActors: hide:)
	)
)

(instance aBill of View
	(properties
		y 190
		x 70
		view 346
		priority 14
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aAlTop of Prop
	(properties
		y 148
		x 102
		view 346
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors: stopUpd:)
	)
)

(instance aAl of View
	(properties
		y 191
		x 99
		view 346
		cel 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aLadyUL_Top of Prop
	(properties
		y 104
		x 45
		view 340
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance atpLadyUL_Bottom of PV
	(properties
		y 133
		x 52
		view 340
		cel 2
	)
)

(instance aLadyLR_Top of Prop
	(properties
		y 156
		x 291
		view 340
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 14 setScript: drinkerScript stopUpd:)
	)
)

(instance atpLadyLR_Bottom of PV
	(properties
		y 185
		x 283
		view 340
		cel 4
	)
)

(instance aManUL_Top of Prop
	(properties
		y 104
		x 281
		view 340
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance atpManUL_Bottom of PV
	(properties
		y 132
		x 275
		view 340
		cel 1
	)
)

(instance talkCycler of Code
	(properties)

	(method (doit)
		(if (Random 0 3)
			(aComic cel: (Random 0 2))
		)
	)
)

(instance aComic of Act
	(properties
		y 58
		x 241
		view 343
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: ComicScript setCycle: Walk stopUpd:)
	)
)

(instance aSign of Prop
	(properties
		y 50
		x 223
		loop 5
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 340 911))
		(super init:)
		(self setPri: 3 stopUpd:)
	)
)

