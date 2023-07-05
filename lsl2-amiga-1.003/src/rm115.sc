;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm115 0
)

(local
	work
)

(instance rm115 of Rm
	(properties
		picture 115
		horizon 5
		south 15
	)

	(method (init)
		(Load rsVIEW 221)
		(Load rsVIEW 222)
		(super init:)
		(gAddToPics
			add:
				aView1
				aView2
				aView3
				aView4
				aView5
				aView6
				aView7
				aView8
				aView9
				aView10
				aView11
				aView12
				aView13
				aView14
				aView15
				aView16
				aView17
				aView18
				aView19
				aView20
				aView21
				aView22
				aView23
			doit:
		)
		(aBell setCycle: Fwd init: setScript: bellScript)
		(aBigClerk
			view: 222
			loop: 1
			posn: 273 1058
			setPri: 15
			setCycle: Fwd
			init:
		)
		(aClerk setPri: 14 illegalBits: 0 stopUpd: init:)
		(self setRegions: 200 setScript: rm115Script) ; rm200
		(if (== gCurrentStatus 3)
			(NormalEgo 0)
			(= gCurrentStatus 3)
			(HandsOff)
			(rm115Script changeState: 13)
		else
			(NormalEgo 0)
			(Load rsSOUND 105)
			(theSound init:)
		)
		(gEgo posn: 64 115 init:)
	)
)

(instance rm115Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 15)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(cond
				((Said '/amp')
					(Print 115 0) ; "There are instruments here from many diverse ethnic cultures. The studios at the rear of the store are filled with people plucking their charangos!"
				)
				((Said '/buffet')
					(Print 115 1) ; "A beautiful Latin lady waits behind the counter, watching your every move."
				)
				((Said '/carpet')
					(Print 115 2) ; "At last, a carpet! You thought this whole city was paved."
				)
				((Said '/door')
					(Print 115 3) ; "The door beneath the bell is clearly labeled "IN" and thus should not be used. However, the door in the south wall is labeled: "OUT.""
					(Print 115 4) ; "Along the walls are locked practice rooms."
				)
				((Said '/carpet')
					(Print 115 5) ; "It's a pretty carpet, isn't it?"
				)
				((Said '/agent,children,woman')
					(aBigClerk posn: 273 58 stopUpd:)
					(Timer setReal: aBigClerk 5)
					(HandsOff)
				)
				((Said '[/airport,building,rack,rack,new,music]')
					(Print 115 6) ; ""Ye Olde Ethno-Musicology Shoppe" is filled with unusual instruments from the four corners of the world."
					(Print 115 7 #at -1 130) ; "(You wonder which ethnic subculture makes such extensive use of electric amplifiers and drum sets!)"
				)
			)
		)
		(if (Said 'apply,get,play/amp')
			(Print 115 8) ; "Perhaps you should talk to the clerk first to see if it's all right for you to mess around with the instruments."
		)
		(if (Said 'buy')
			(if (gEgo has: 4) ; Million_Dollar_Bill
				(Print 115 9) ; ""Do you have change for a million?" you ask the clerk."
				(Print 115 10) ; ""Non habla anglais," replies the clerk."
			else
				(Print 115 11) ; ""May I buy something here?" you ask."
				(Print 115 10) ; ""Non habla anglais," replies the clerk."
			)
		)
		(if (Said 'open/door')
			(Print 115 3) ; "The door beneath the bell is clearly labeled "IN" and thus should not be used. However, the door in the south wall is labeled: "OUT.""
			(Print 115 4) ; "Along the walls are locked practice rooms."
		)
		(if (Said 'talk/woman,children,agent')
			(cond
				((not (gEgo inRect: 61 139 76 157))
					(NotClose) ; "You're not close enough."
				)
				((not ((gInventory at: 10) ownedBy: gCurRoomNum)) ; Onklunk
					(AlreadyTook) ; "You already took it."
				)
				((== gLAhaircut 0)
					(Print (Format @gString 115 12 gLaffer)) ; ""Hello, beautiful," you tell her. %s"
					(Print 115 13) ; ""Buenos dias, Senor." she responds with a blank stare."
					(Print 115 14 #at -1 130) ; "(Apparently she doesn't speak English.)"
				)
				(else
					(self changeState: 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(Print (Format @gString 115 15 gLaffer)) ; ""Hi, beautiful," you attempt to lay a little smooth-mouth on the lovely Latin lady. %s"
				(aClerk setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(aClerk setLoop: 0 setCel: 0)
				(Print 115 16 #at -1 20 #font gUserFont #dispose) ; ""Buenos dias, Senor Dos assistanta bello bono?" la senorita el talkos."
				(Print 115 17 #at -1 130 #font gSmallFont) ; "("Good day, Sir. How may I help you?")"
				(cls)
				(= seconds 3)
			)
			(3
				(Print 115 18) ; "Suddenly, she smiles broadly... as if she recognizes you!"
				(Print 115 19) ; "Her smile makes you glad you took Spanish in high school."
				(Print 115 20) ; "(Too bad you slept through it!)"
				(= seconds 3)
			)
			(4
				(if (> gFilthLevel 4)
					(Print 115 21) ; "Aw, what the hell. You decide to brush the dust off your Spanish by attempting a conversation with the lovely senorita."
				else
					(Print 115 22) ; "Aw, what the heck. You decide to brush the dust off your Spanish by attempting a conversation with the lovely senorita."
				)
				(Print 115 23) ; "Perhaps you could begin by complimenting her on her extremely good looks..."
				(Print 115 24 #at -1 20 #font gUserFont #dispose) ; ""El pesto la guardia say spermo boobitos," you tell her."
				(Print 115 25 #at -1 130 #font gSmallFont) ; "("Your ears remind me of whale breasts.")"
				(cls)
				(aClerk setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(aClerk setLoop: 0 setCel: 0)
				(Print 115 26) ; "Her face brightens further -- she seems genuinely interested in you. Your Spanish must not be so bad after all!"
				(Print 115 27 #at -1 20 #font gUserFont #dispose) ; ""Si, sa la luna el gross et poopie-doggie la bambino," la senorita reporitos."
				(Print 115 28 #at -1 130 #font gSmallFont) ; "("Yes, but the moon is full, and you are a chihuahua.")"
				(cls)
				(= seconds 3)
			)
			(6
				(Print 115 29) ; "Whoa! Speaking is one thing, but understanding is another! Her response baffles you completely. You have no idea what she means."
				(Print 115 30) ; "Of course, that's never stopped you before..."
				(Print 115 31 #at -1 20 #font gUserFont #dispose) ; ""El pencilo es tubular, rigido amarillo," you tell her."
				(Print 115 32 #at -1 130 #font gSmallFont) ; "("My pencil is long, hard and yellow.")"
				(cls)
				(aClerk setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(aClerk setLoop: 0 setCel: 0)
				(Print 115 33 #at -1 20 #font gUserFont #dispose) ; ""El hombre del na nostra donde esta majora signale. La writo de stupido sententates," la senorita charma."
				(Print 115 34 #at -1 130 #font gSmallFont) ; "("So you're finally here! I thought you'd never show up. By the way, who writes these secret phrases, anyway?")"
				(cls)
				(Print 115 35 #at -1 20 #font gUserFont #dispose) ; "La microfiche la enigm big dealo onklunk no touche, Dr. Nonookee el commie."
				(Print 115 36 #at 20 110 #width 270 #font gSmallFont) ; "("The microfiche containing the secrets to the recent United States' superconductor research breakthrough is hidden inside this rare, Peruvian onklunk. Don't let anyone touch it before you personally deliver it to Dr. Nonookee. And (I don't need to tell you) be careful: he, and he alone, has the authority to deliver it to the USSR agents!")"
				(cls)
				(aClerk setLoop: 3 setCel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(8
				(aClerk setLoop: 0 cycleSpeed: 0 setCel: 0)
				(aOnklunk setPri: 14 stopUpd: init:)
				(= seconds 3)
			)
			(9
				(Print 115 37 #at -1 20 #font gUserFont #dispose) ; ""Mucho gracias, la Senorita,"
				(Print 115 38 #at -1 130 #font gSmallFont) ; "("Thanks, I guess.")"
				(cls)
				(= seconds 3)
			)
			(10
				(Print 115 39) ; "As best you can tell, she wants you to keep that unusual musical instrument on the counter. So, rather than risk offending her generosity, you take it."
				(gEgo get: 10) ; Onklunk
				(gGame changeScore: 7)
				(aOnklunk dispose:)
				(= seconds 3)
			)
			(11
				(Print 115 40 #at -1 20 #font gUserFont #dispose) ; "Have zeee nice dayo."
				(Print
					(Format @gString 115 41 gTritePhrase) ; "("%s")"
					#at
					-1
					130
					#font
					gSmallFont
				)
				(cls)
				(gEgo setMotion: MoveTo 220 166 self)
			)
			(12
				(gEgo setMotion: MoveTo 222 182)
			)
			(13
				(gEgo setMotion: MoveTo 73 141 self)
				(= cycles 6)
			)
			(14
				(Print 115 42) ; "You! What are you doing back here?!" says the clerk, skipping the foreign language subtitles completely. "You'd better get on with the mission before Dr. Nonookee prevents you from ever missioning again!"
			)
			(15
				(gEgo setLoop: 1)
				(Print 115 43 #draw) ; "What are you talking about? I've never seen you before in my entire life!" says the dorky-looking guy, "Besides, you're not supposed to talk to me like that before we exchange our cute, little, secret phrases!"
				(Print 115 44) ; "What do you mean," she responds, "you just walked out that other door over there!"
				(Print 115 45) ; "Not me!" he exclaims. "Hey! Wait a minute! Don't tell me you gave the goods to someone else?"
				(theSound play:)
				(Print 115 46) ; "I, eh, uh," she stammers, "I'm not sure, that is, there may be a... I may have..."
				(Print 115 47) ; "Her voice trembles with fear!"
				(= seconds 3)
			)
			(16
				(Print 115 48) ; "I'm sorry, he fit your description perfectly! And he said the secret code phrases as well!! Although, come to think of it, he DID have a terrible accent. I thought the bad accent might have been part of your disguise."
				(= seconds 3)
			)
			(17
				(Print 115 49) ; "What will I do?" she continues, "Dr. Nonookee doesn't tolerate mistakes!"
				(Print 115 50) ; "Her eyes flash with an idea, "Of course, if you promise to help me, I won't tell him how you lost the microfiche!""
				(Print 115 51) ; "Why, you..." he threatens, "if you know what's good for you, you'll shut down this joint, contact Nontoonyt Island, and get the troops started finding this guy. They'll guarantee he tells no tales about your little indiscretion! If you can retrieve the microfiche before he discovers what he has, Dr. Nonookee might even allow you to live a few extra days!"
				(= seconds 3)
			)
			(18
				(Print 115 52) ; "She deliberates just a moment before making her decision."
				(Print 115 53) ; "You're right, of course. You see if you can follow him, while I contact the island by radiotelephone."
				(= seconds 2)
			)
			(19
				(gEgo setLoop: -1 setMotion: MoveTo 220 166 self)
			)
			(20
				(gEgo loop: 2 setMotion: 0)
				(Print 115 54 #draw) ; "Well, Larry, this is certainly another fine mess you've gotten us into!"
				(Print 115 55) ; "Not only is the KGB after you for grabbing what was supposed to be theirs, but Dr. Nonookee's beautiful army of henchettes, game show hostesses, church secretaries, and bimbos is now hot on your tail!"
				(Print 115 56) ; "Since we've now learned the worst, we'll rejoin you as you wander through Los Angeles..."
				(SetRgTimer 1 4 30)
				(gCurRoom newRoom: 21)
			)
		)
	)
)

(instance bellScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(aBell cycleSpeed: 1)
				(= cycles 7)
			)
			(2
				(aBell cycleSpeed: 2)
				(= cycles 9)
			)
			(3
				(aBell cycleSpeed: 3)
				(= cycles 11)
			)
			(4
				(aBell setCel: 2 stopUpd:)
			)
		)
	)
)

(instance aBigClerk of Prop
	(properties)

	(method (cue)
		(Print 115 57) ; "You find Latin American women sexy."
		(Print 115 58 #at 55 155 #width 210) ; "(But then, you find any woman sexy!)"
		(self posn: 273 1058)
		(HandsOn)
	)
)

(instance theSound of Sound
	(properties
		number 105
	)
)

(instance aView1 of PV
	(properties
		y 63
		x 225
		view 221
		loop 2
		cel 3
	)
)

(instance aView2 of PV
	(properties
		y 87
		x 267
		view 221
		loop 2
		cel 4
	)
)

(instance aView3 of PV
	(properties
		y 45
		x 149
		view 221
		loop 2
		cel 5
	)
)

(instance aView4 of PV
	(properties
		y 99
		x 102
		view 221
		loop 3
		cel 4
	)
)

(instance aView5 of PV
	(properties
		y 96
		x 120
		view 221
		loop 3
		cel 4
	)
)

(instance aView6 of PV
	(properties
		y 100
		x 134
		view 221
		loop 3
		cel 3
	)
)

(instance aView7 of PV
	(properties
		y 100
		x 145
		view 221
		loop 3
		cel 3
	)
)

(instance aView8 of PV
	(properties
		y 101
		x 162
		view 221
		loop 2
	)
)

(instance aView9 of PV
	(properties
		y 101
		x 186
		view 221
		loop 2
	)
)

(instance aView10 of PV
	(properties
		y 109
		x 156
		view 221
		loop 2
	)
)

(instance aView11 of PV
	(properties
		y 109
		x 191
		view 221
		loop 2
	)
)

(instance aView12 of PV
	(properties
		y 101
		x 90
		view 221
		loop 2
	)
)

(instance aView13 of PV
	(properties
		y 151
		x 69
		view 221
		loop 3
		priority 15
		signal 16384
	)
)

(instance aView14 of PV
	(properties
		y 103
		x 23
		view 221
		loop 3
		cel 2
	)
)

(instance aView15 of PV
	(properties
		y 113
		view 221
		loop 3
		cel 2
	)
)

(instance aView16 of PV
	(properties
		y 79
		x 31
		view 221
		loop 3
		cel 1
	)
)

(instance aView17 of PV
	(properties
		y 86
		x 41
		view 221
		loop 3
		cel 1
	)
)

(instance aView18 of PV
	(properties
		y 77
		x 172
		view 221
		loop 2
		cel 1
		priority 6
	)
)

(instance aView19 of PV
	(properties
		y 104
		x 89
		view 221
		loop 2
		cel 2
		priority 7
	)
)

(instance aView20 of PV
	(properties
		y 135
		x 209
		view 221
		loop 3
		cel 5
		signal 16384
	)
)

(instance aView21 of PV
	(properties
		y 70
		x 140
		view 221
		loop 3
		cel 7
	)
)

(instance aView22 of PV
	(properties
		y 118
		x 42
		view 221
		loop 3
		cel 6
		priority 13
		signal 16384
	)
)

(instance aView23 of PV
	(properties
		y 105
		x 67
		view 221
		priority 7
		signal 16384
	)
)

(instance aBell of Prop
	(properties
		y 62
		x 63
		view 221
		loop 1
	)
)

(instance aClerk of Act
	(properties
		y 152
		x 41
		view 222
		signal 16384
	)
)

(instance aOnklunk of View
	(properties
		y 132
		x 51
		view 222
		loop 4
		signal 16384
	)
)

