;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use n013)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	troub 0
)

(local
	[local0 2]
)

(instance troub of Rm
	(properties
		style -32758
	)

	(method (init)
		(HandsOff)
		(LoadMany rsPIC 800 830 835 840 845 850 803)
		(LoadMany rsVIEW 800 835 850 840)
		(LoadMany rsSOUND 2 3 4)
		(super init:)
		(gTheIconBar disable: 0 1 2 3 4 5 6 7)
		(HandsOff)
		(= global156 0)
		(= global151 0)
		(if (!= gPrevRoomNum 422) ; hanging
			(gCurRoom drawPic: 800 -32758)
			(bardsHead init: setScript: sing)
			(bardsHand init: setScript: strum)
			(bardsFingers init: setScript: riff)
			(if (IsFlag 62)
				(+= global156 2000)
			)
			(if (IsFlag 49)
				(if (IsFlag 151)
					(+= global156 500)
				else
					(-= global156 500)
				)
			)
			(if (IsFlag 113)
				(if (IsFlag 152)
					(+= global156 500)
				else
					(-= global156 500)
				)
			)
			(if (IsFlag 174)
				(+= global156 500)
			else
				(-= global156 500)
			)
			(if (IsFlag 173)
				(+= global156 500)
			else
				(-= global156 500)
			)
			(+= global156 (* 30 (- gOutlaws 9)))
			(cond
				(
					(and
						(u< global146 5000)
						(or
							(< global156 2500)
							(u< global146 1000)
							(< (+ global156 global146) 5000)
						)
					)
					(= global151 40)
				)
				(
					(or
						(< global156 3680)
						(and (u< global146 -14536) (IsFlag 65))
						(and (u< global146 15300) (not (IsFlag 65)))
					)
					(= global151 30)
				)
				((or (< global156 4250) (u< global146 -4536))
					(if (IsFlag 62)
						(= global151 20)
					else
						(= global151 30)
					)
				)
				(else
					(= global151 10)
				)
			)
			(self setScript: bardsTheme)
		else
			(gCurRoom drawPic: 840 -32758)
			(robinH init:)
			(soldier init:)
			(hangman init:)
			(sheriffsPate init:)
			(sheriffsKnuckles init:)
			(gAddToPics add: johnnieHangs tuckieHangs eachElementDo: #init doit:)
			(self setScript: dieScum)
			(sheriffsPate setScript: fret)
			(sheriffsKnuckles setScript: drum)
		)
	)
)

(instance bardsHead of Prop
	(properties
		x 132
		y 44
		view 800
		priority 12
		signal 16
	)
)

(instance bardsHand of Prop
	(properties
		x 120
		y 57
		view 800
		loop 1
		priority 15
		signal 16
	)
)

(instance bardsFingers of Prop
	(properties
		x 202
		y 51
		view 800
		loop 2
		priority 15
		signal 16
	)
)

(instance baddie1 of Prop
	(properties
		x 16
		y 88
		view 835
		priority 12
		signal 16
	)
)

(instance baddie2 of Prop
	(properties
		x 242
		y 92
		view 835
		loop 1
		priority 12
		signal 16
	)
)

(instance baddie3 of Prop
	(properties
		x 158
		y 45
		view 835
		loop 3
		priority 12
		signal 16
	)
)

(instance baddie4 of Prop
	(properties
		x 236
		y 67
		view 835
		loop 4
		priority 12
		signal 16
	)
)

(instance tuckie of Prop
	(properties
		x 200
		y 18
		view 835
		loop 2
		priority 12
		signal 16
	)
)

(instance sheriffsHead of Prop
	(properties
		x 91
		y 57
		view 850
	)
)

(instance sheriffsHand of Prop
	(properties
		x 94
		y 62
		view 850
		loop 1
	)
)

(instance robinsHead of Prop
	(properties
		x 187
		y 51
		view 850
		loop 2
	)
)

(instance robinsRightHand of Prop
	(properties
		x 153
		y 64
		view 850
		loop 3
	)
)

(instance robinsLeftHand of Prop
	(properties
		x 208
		y 51
		view 850
		loop 4
	)
)

(instance kingsHead of Prop
	(properties
		x 258
		y 63
		view 850
		loop 5
	)
)

(instance soldier of Prop
	(properties
		x 155
		y 140
		view 840
		loop 1
		priority 10
		signal 16
	)
)

(instance hangman of Prop
	(properties
		x 177
		y 84
		view 840
		loop 3
		signal 16
	)
)

(instance sheriffsPate of Prop
	(properties
		x 64
		y 113
		view 840
		loop 2
		priority 7
		signal 16
	)
)

(instance sheriffsKnuckles of Prop
	(properties
		x 57
		y 170
		view 840
		priority 13
		signal 16
	)
)

(instance robinH of Actor
	(properties
		x 196
		y 48
		view 840
		loop 4
		priority 1
		signal 16
	)
)

(instance johnnieHangs of PicView
	(properties
		x 204
		y 164
		view 840
		loop 6
		priority 12
		signal 16
	)
)

(instance tuckieHangs of PicView
	(properties
		x 228
		y 158
		view 840
		loop 5
		priority 11
		signal 16
	)
)

(instance swinger of View
	(properties
		x 150
		y 65
		view 840
		loop 7
	)
)

(instance sing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= ticks (* 6 (Random 1 2)))
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= ticks (* 6 (Random 1 2)))
			)
			(4
				(client setCycle: End self)
			)
			(5
				(= ticks (* 6 (Random 1 2)))
			)
			(6
				(client setCycle: Beg self)
			)
			(7
				(= ticks (* 6 (Random 1 2)))
			)
			(8
				(client setCycle: End self)
			)
			(9
				(= ticks (* 6 (Random 1 2)))
			)
			(10
				(client setCycle: Beg self)
			)
			(11
				(= ticks (* 6 (Random 1 2)))
			)
			(12
				(client cel: 1)
				(= ticks 6)
			)
			(13
				(client cel: 0)
				(= ticks (* 10 (Random 4 11)))
			)
			(14
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance strum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(= ticks 12)
			)
			(1
				(client cel: 0)
				(= ticks 12)
			)
			(2
				(client cel: 1)
				(= ticks 60)
			)
			(3
				(client cel: 0)
				(= ticks 36)
			)
			(4
				(client cel: 1)
				(= ticks 48)
			)
			(5
				(client cel: 0)
				(= ticks 30)
			)
			(6
				(client cel: 1)
				(= ticks 48)
			)
			(7
				(client cel: 0)
				(= ticks 12)
			)
			(8
				(client cel: 1)
				(= ticks 12)
			)
			(9
				(client cel: 0)
				(= ticks 12)
			)
			(10
				(client cel: 1)
				(= ticks 60)
			)
			(11
				(client cel: 0)
				(= ticks 48)
			)
			(12
				(client cel: 1)
				(= ticks 30)
			)
			(13
				(client cel: 0)
				(= ticks 42)
			)
			(14
				(client cel: 1)
				(= ticks 36)
			)
			(15
				(client cel: 0)
				(= ticks 6)
			)
			(16
				(= ticks 6)
				(= state -1)
			)
		)
	)
)

(instance riff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client cel: 1)
				(= ticks 12)
			)
			(2
				(client cel: 2)
				(= ticks 18)
			)
			(3
				(client cel: 0)
				(= ticks 12)
			)
			(4
				(client setCycle: End self)
			)
			(5
				(client cel: 1)
				(= ticks 18)
			)
			(6
				(client cel: 0)
				(= ticks 18)
			)
			(7
				(client cel: 2)
				(= ticks 12)
			)
			(8
				(client setCycle: Beg self)
			)
			(9
				(= ticks 24)
				(= state -1)
			)
		)
	)
)

(instance bardsTheme of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(gCurRoom setScript: itsNotOver)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic number: 4 loop: -1 play: fade: 127 6 12 0)
				(= ticks 180)
			)
			(1
				(SetMessageColor 10)
				(Say 1800 0 self 67 55 150 80 {Troubadour}) ; "Surely, you think, this cannot be the end of the story? Nay, there is much yet to tell."
			)
			(2
				(Say 1800 1 self 67 55 150 80 {Troubadour}) ; "What follows is a time of waiting. Waiting for the treasure to reach the Queen. Waiting for the ransom to reach King Leopold in Austria."
			)
			(3
				(Say 1800 2 self 67 55 150 80 {Troubadour}) ; "Waiting for King Richard to be freed and return to England."
			)
			(4
				(if (IsFlag 62)
					(gCurRoom setScript: itsNotOver)
				else
					(= ticks 6)
				)
			)
			(5
				(Say 1800 3 self 67 55 150 80 {Troubadour}) ; "You wait through the long and dreary months of winter for some word of your King's fate. None comes."
			)
			(6
				(Say 1800 4 self 67 55 150 80 {Troubadour}) ; "In winter, friend and foe alike keep to shelter and all is quiet."
			)
			(7
				(gCurRoom setScript: itsNotOver)
				(self dispose:)
			)
		)
	)
)

(instance theLoveNest of Script
	(properties)

	(method (dispose)
		(DoSound sndGLOBAL_REVERB 0)
		(rainSound dispose:)
		(super dispose: &rest)
	)

	(method (doit)
		(Palette palANIMATE 240 245 -1)
		(Palette palANIMATE 246 251 -1)
		(Palette palANIMATE 252 255 -1)
		(super doit: &rest)
	)

	(method (cue param1)
		(if (and argc (not param1))
			(itsNotOver start: 1)
			(gCurRoom setScript: itsNotOver)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoSound sndGLOBAL_REVERB 20)
				(rainSound play:)
				(= ticks 30)
			)
			(1
				(gCurRoom drawPic: 830 -32758)
				(= ticks 300)
			)
			(2
				(Say 1800 3 self 67 55 150 80 {Troubadour}) ; "You wait through the long and dreary months of winter for some word of your King's fate. None comes."
			)
			(3
				(Say 1800 4 self 67 55 150 80 {Troubadour}) ; "In winter, friend and foe alike keep to shelter and all is quiet."
			)
			(4
				(gRgnMusic fade: 48 6 12 0)
				(= ticks 180)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance theCapture of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(itsNotOver start: 2)
			(gCurRoom setScript: itsNotOver)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic number: 6 loop: -1 play: fade: 127 6 12 0)
				(= ticks 30)
			)
			(1
				(gCurRoom drawPic: 835 -32758)
				(baddie1 init: cel: 1)
				(baddie2 init: cel: 1)
				(baddie3 init: cel: 1)
				(baddie4 init: cel: 1)
				(tuckie init: cel: 1)
				(= ticks 60)
			)
			(2
				(Say 1800 7 self 67 55 150 80 {Troubadour}) ; "As the spring of 1194 renews the green of the forest, you go forth with your men to hunt and refill the larders."
			)
			(3
				(baddie1 cel: 0)
				(baddie2 cel: 0)
				(baddie3 cel: 0)
				(baddie4 cel: 0)
				(tuckie cel: 0)
				(= ticks 12)
			)
			(4
				(Say 1800 8 self 67 55 150 80 {Troubadour}) ; "But alas, all your luck flees, all your cunning fails you, and you are taken by the Sheriff's men!"
			)
			(5
				(= ticks 180)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance theGallows of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(itsNotOver start: 3)
			(gCurRoom setScript: itsNotOver)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gCurRoom drawPic: 840 -32758)
				(sheriffsPate init: setScript: fret)
				(sheriffsKnuckles init: setScript: drum)
				(soldier init:)
				(hangman init:)
				(robinH init:)
				(johnnieHangs init:)
				(tuckieHangs init:)
				(= ticks 60)
			)
			(2
				(soldier cel: 0)
				(= ticks 6)
			)
			(3
				(soldier cel: 1)
				(= ticks 12)
			)
			(4
				(soldier cel: 0)
				(= ticks 6)
			)
			(5
				(soldier cel: 1)
				(= ticks 12)
			)
			(6
				(Say 1800 9 self 67 55 150 80 {Troubadour}) ; "The Sheriff declares you guilty upon the spot and has you and all your men led to the gallows as quickly as possible."
			)
			(7
				(Say 1800 10 self 67 55 150 80 {Troubadour}) ; "That he dares such a thing without a trial can only mean he is sure of Prince John's power to protect him."
			)
			(8
				(soldier cel: 0)
				(= ticks 6)
			)
			(9
				(soldier cel: 1)
				(= ticks 12)
			)
			(10
				(soldier cel: 0)
				(= ticks 6)
			)
			(11
				(soldier cel: 1)
				(= ticks 12)
			)
			(12
				(Say 1800 11 self 67 55 150 80 {Troubadour}) ; "Despair fills your soul. To have fought so long and so well only to dance at the end of a rope..."
			)
			(13
				(gRgnMusic fade: 60 30 6 1)
				(= ticks 180)
			)
			(14
				(self dispose:)
			)
		)
	)
)

(instance theKingRidesIn of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(itsNotOver start: 4)
			(gCurRoom setScript: itsNotOver)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic number: 2 loop: -1 play: fade: 127 6 12 0)
				(= ticks 30)
			)
			(1
				(Say 1800 12 self 67 55 150 80 {Troubadour}) ; "Yet even as the rope tightens about your neck, you hear the drumming of hooves, blare of horns, clash of steel!"
			)
			(2
				(Say 1800 13 self 67 55 150 80 {Troubadour}) ; "King Richard has come to Nottingham!"
			)
			(3
				(gRgnMusic fade: 60 30 6 1)
				(= ticks 180)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance theAccused of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(gRgnMusic fade: 60 6 30 0)
			(gCurRoom newRoom: 420) ; jment
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic number: 3 loop: -1 play: fade: 127 6 12 0)
				(= ticks 30)
			)
			(1
				(gCurRoom drawPic: 850 -32758)
				(sheriffsHead init:)
				(sheriffsHand init: cel: 1)
				(robinsHead init:)
				(robinsRightHand init:)
				(robinsLeftHand init:)
				(kingsHead init:)
				(= ticks 180)
			)
			(2
				(kingsHead cel: 0)
				(SetMessageColor 31)
				(Say 1800 14 self 67 55 150 80 {King Richard}) ; "Word came to me, Master Sheriff, that you'd captured the great outlaw, Robin Hood."
			)
			(3
				(Say 1800 15 self 67 55 150 80 {King Richard}) ; "But I heard nothing of a trial! Is this the way you've kept the law in my absence?"
			)
			(4
				(sheriffsHand cel: 0)
				(sheriffsHead setScript: sheriffTalks)
				(SetMessageColor 17)
				(Say 1800 16 self 67 55 150 80 {Sheriff}) ; "B-but, my lord, my King, he is a terrible outlaw, guilty of every sort of crime. I saw no need!"
			)
			(5
				(sheriffsHead setScript: 0)
				(sheriffsHand cel: 1)
				(= ticks 6)
			)
			(6
				(robinsHead cel: 1)
				(= ticks 18)
			)
			(7
				(robinsRightHand cel: 1)
				(kingsHead cel: 1)
				(= ticks 6)
			)
			(8
				(robinsLeftHand cel: 1)
				(= ticks 12)
			)
			(9
				(robinsRightHand cel: 0)
				(= ticks 12)
			)
			(10
				(robinsHead cel: 0)
				(= ticks 6)
			)
			(11
				(robinsLeftHand cel: 0)
				(= ticks 6)
			)
			(12
				(robinsHead cel: 1)
				(SetMessageColor 0)
				(Say 1800 17 self 67 55 150 80 {Robin}) ; "My Liege, hear me! I am your true and loyal servant. I did not choose to be an outlaw, but was driven to it by corrupt and evil men."
			)
			(13
				(sheriffsHead setCycle: End)
				(kingsHead cel: 0)
				(robinsHead cel: 0)
				(sheriffsHand cel: 0)
				(SetMessageColor 17)
				(Say 1800 18 self 67 55 150 80 {Sheriff}) ; "Silence, you thieving dog..."
			)
			(14
				(sheriffsHand cel: 1)
				(sheriffsHead cel: 0)
				(SetMessageColor 31)
				(Say 1800 19 self 67 55 150 80 {King Richard}) ; "Enough! I will hear him speak."
			)
			(15
				(sheriffsHead cel: 4)
				(robinsHead cel: 1)
				(kingsHead cel: 1)
				(SetMessageColor 0)
				(Say 1800 20 self 67 55 150 80 {Robin}) ; "My king, do you know nothing of the money we sent for your ransom? Not one penny did I or my men keep that we could send to win your freedom."
			)
			(16
				(sheriffsHead cel: 0)
				(SetMessageColor 31)
				(Say 1800 21 self 67 55 150 80 {King Richard}) ; "I've not had word from my mother the Queen to account for every mark. If what you say is true..."
			)
			(17
				(sheriffsHead setScript: sheriffTalks)
				(sheriffsHand cel: 0)
				(kingsHead cel: 0)
				(robinsHead cel: 0)
				(SetMessageColor 17)
				(Say 1800 22 self 67 55 150 80 {Sheriff}) ; "My lord, you cannot take seriously the rantings of a desperate man! He will say anything to save his neck!"
			)
			(18
				(sheriffsHead setScript: 0 cel: 0)
				(sheriffsHand cel: 1)
				(robinsHead cel: 1)
				(SetMessageColor 31)
				(Say 1800 23 self 67 55 150 80 {King Richard}) ; "Then it will be decided as it should have been - in the Court of Justice!"
			)
			(19
				(gRgnMusic fade: 60 30 6 1)
				(= ticks 180)
			)
			(20
				(self dispose:)
			)
		)
	)
)

(instance sheriffTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= ticks (* 10 (Random 4 11)))
			)
			(1
				(client setCycle: Beg)
				(= ticks (* 10 (Random 4 11)))
			)
			(2
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance itsNotOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 62)
					(gCast eachElementDo: #dispose)
					(gCurRoom drawPic: 803 -32762)
					(self setScript: theLoveNest self)
				else
					(= ticks 1)
				)
			)
			(1
				(gRgnMusic fade: 60 6 12 0)
				(if (not (IsFlag 62))
					(gCast eachElementDo: #dispose)
				)
				(gCurRoom drawPic: 803 -32762)
				(self setScript: theCapture self)
			)
			(2
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 803 -32762)
				(self setScript: theGallows self)
			)
			(3
				(gRgnMusic fade: 60 6 12 0)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 845 -32758)
				(self setScript: theKingRidesIn self)
			)
			(4
				(gRgnMusic fade: 48 6 18 0)
				(gCurRoom drawPic: 803 -32762)
				(self setScript: theAccused self)
			)
			(5
				(gRgnMusic fade: 60 6 12 0)
				(= ticks 72)
			)
			(6
				(gCurRoom newRoom: 420) ; jment
				(self dispose:)
			)
		)
	)
)

(instance rainSound of Sound
	(properties
		flags 1
		number 142
		loop -1
	)
)

(instance dieScum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(soldier cel: 0)
				(= ticks 6)
			)
			(2
				(soldier cel: 1)
				(= ticks 12)
			)
			(3
				(soldier cel: 0)
				(= ticks 6)
			)
			(4
				(soldier cel: 1)
				(= ticks 12)
			)
			(5
				(robinH setScript: hang)
				(= ticks 120)
			)
			(6
				(gAddToPics eachElementDo: #dispose)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 803 -32762)
				(swinger init:)
				(creakSound number: 16 play:)
				(= ticks 300)
			)
			(7
				(swinger dispose:)
				(gRgnMusic number: 14 loop: -1 play: fade: 127 6 12 0)
				(= ticks 30)
			)
			(8
				(gCurRoom drawPic: 800 -32758)
				(bardsHead init: setScript: sing)
				(bardsHand init: setScript: strum)
				(bardsFingers init: setScript: riff)
				(gCurRoom setScript: bardsTheme2)
				(= cycles 2)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance hang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hangman setCycle: End)
				(robinH cycleSpeed: 12 setCycle: End self)
			)
			(1
				(creakSound play: self)
			)
			(2
				(= ticks 6)
			)
			(3
				(robinH cel: 3)
				(= ticks 36)
			)
			(4
				(robinH cel: 4)
				(= ticks 24)
			)
			(5
				(robinH cel: 5)
				(= ticks 36)
			)
			(6
				(robinH cel: 4)
				(= ticks 24)
			)
			(7
				(= state 3)
				(= ticks 6)
			)
			(8
				(creakSound number: 18 play: self)
			)
		)
	)
)

(instance bardsTheme2 of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(Say 1800 24 self 67 55 150) ; "Truly a sad and pathetic performance. But I know you are capable of doing far, far better."
			)
			(2
				(Say 1800 25 self 67 55 150) ; "I shall look forward to a much happier ending after your next attempt as Robin Hood!"
			)
			(3
				(gRgnMusic fade: 60 6 12 0)
				(= ticks 72)
			)
			(4
				(gCurRoom newRoom: 97) ; theEnd
				(self dispose:)
			)
		)
	)
)

(instance drum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0)
				(= ticks 6)
			)
			(1
				(client cel: 1)
				(= ticks 60)
			)
			(2
				(client cel: 0)
				(= ticks 30)
			)
			(3
				(client cel: 1)
				(= ticks 180)
			)
			(4
				(client cel: 0)
				(= ticks 90)
			)
			(5
				(client cel: 0)
				(= ticks 30)
			)
			(6
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance fret of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 24)
			)
			(1
				(client cel: 0)
				(= ticks 6)
			)
			(2
				(client cel: 1)
				(= ticks 60)
			)
			(3
				(client cel: 0)
				(= ticks 30)
			)
			(4
				(= ticks 30)
			)
			(5
				(client cel: 1)
				(= ticks 180)
			)
			(6
				(client cel: 0)
				(= ticks 90)
			)
			(7
				(client cel: 0)
				(= ticks 30)
			)
			(8
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance creakSound of Sound
	(properties
		flags 1
		number 17
	)
)

