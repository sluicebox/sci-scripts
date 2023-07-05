;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	open 0
)

(local
	local0
)

(instance open of Rm
	(properties
		picture 800
		style 8
	)

	(method (init)
		(HandsOff)
		(LoadMany rsPIC 800 810 820 825)
		(LoadMany rsVIEW 800 810 820 825 14 153 156 159 162 165)
		(LoadMany rsSOUND 101 102 103 104)
		(bardsHead init: setScript: sing)
		(bardsHand init: setScript: strum)
		(bardsFingers init: setScript: riff)
		(bardsToes init: setScript: tap)
		(super init:)
		(if (not global102)
			(gGame setCursor: 5 1)
		)
		(self setScript: bardsTheme)
	)

	(method (dispose)
		(gRgnMusic flags: (| (gRgnMusic flags:) $0001))
		(SetMessageColor 0)
		(super dispose: &rest)
	)
)

(class ZScript of Script
	(properties)

	(method (init param1 param2 param3)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init: param1 param2 param3 &rest)
	)

	(method (dispose &tmp temp0)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if
			(or
				(and (& (event modifiers:) emSHIFT) (& (event type:) evMOUSEBUTTON))
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(gCurRoom setScript: lastScript)
		)
	)

	(method (cue param1)
		(if (and argc (not param1))
			(gCurRoom setScript: lastScript)
		else
			(super cue: &rest)
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
		detailLevel 1
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
		detailLevel 2
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
		detailLevel 2
	)
)

(instance bardsToes of Prop
	(properties
		x 230
		y 176
		view 800
		loop 3
		detailLevel 3
	)
)

(instance richie of Actor
	(properties
		x 44
		y 154
		view 810
		signal 16400
	)
)

(instance mule of Actor
	(properties
		x 2
		y 154
		view 810
		loop 1
		signal 18448
		detailLevel 1
	)
)

(instance knave of Actor
	(properties
		x 290
		y 158
		view 810
		loop 5
		signal 18432
		detailLevel 2
	)
)

(instance kingsHead of Prop
	(properties
		x 196
		y 104
		view 820
	)
)

(instance leftHand of Prop
	(properties
		x 155
		y 42
		view 820
		loop 1
	)
)

(instance rightHand of Prop
	(properties
		x 238
		y 100
		view 820
		loop 2
	)
)

(instance leoHead of Prop
	(properties
		x 71
		y 32
		view 825
		detailLevel 2
	)
)

(instance leoHand of Prop
	(properties
		x 53
		y 23
		view 825
		loop 1
		priority 15
		detailLevel 2
	)
)

(instance richieHand of Prop
	(properties
		x 271
		y 139
		view 825
		loop 2
		detailLevel 1
	)
)

(instance guardHead of Prop
	(properties
		x 216
		y 64
		view 825
		loop 3
	)
)

(instance johnnie of View
	(properties
		x 240
		y 67
		view 153
		loop 1
	)
)

(instance tuckie of View
	(properties
		x 32
		y 116
		view 156
		loop 1
	)
)

(instance alanD of View
	(properties
		x 84
		y 148
		view 159
		loop 1
	)
)

(instance willie of View
	(properties
		x 287
		y 107
		view 162
		loop 1
	)
)

(instance muchie of View
	(properties
		x 244
		y 148
		view 165
		loop 1
	)
)

(instance robbie of View
	(properties
		x 84
		y 67
		view 14
	)
)

(instance frameRobin of View
	(properties
		x 82
		y 68
		view 14
		cel 1
	)
)

(instance frameTuck of View
	(properties
		x 30
		y 117
		view 14
		cel 1
	)
)

(instance frameAlan of View
	(properties
		x 82
		y 149
		view 14
		cel 1
	)
)

(instance frameJohn of View
	(properties
		x 238
		y 68
		view 14
		cel 1
	)
)

(instance frameWill of View
	(properties
		x 285
		y 108
		view 14
		cel 1
	)
)

(instance frameMuch of View
	(properties
		x 242
		y 149
		view 14
		cel 1
	)
)

(instance bardsTheme of ZScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic fade: 60 30 16 1)
				(= ticks 120)
			)
			(1
				(gRgnMusic
					number: 101
					loop: 1
					init:
					play: self
					fade: 127 60 8 0
					flags: (& (gRgnMusic flags:) $fffe)
				)
				(SetMessageColor 10)
				(= ticks 6)
			)
			(2
				(Say 95 0 108 67 50 150 80 {Troubadour}) ; "In the year of Our Most Gracious Lord Eleven hundred and ninety-three,..."
			)
			(3
				(Say 95 1 108 67 50 150) ; "Good King Richard the Lionheart Sailed across the sea."
			)
			(4
				(Say 95 2 108 67 50 150) ; "The infidels he had besieged But Jerusalem was lost,..."
			)
			(5
				(Say 95 3 108 67 50 150) ; "Bloody was the Third Crusade, Dearly did it cost."
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gRgnMusic fade: 60 12 8 0)
				(= ticks 6)
			)
			(7
				(gCurRoom setScript: nightRider)
				(self dispose:)
			)
		)
	)
)

(instance nightRider of ZScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 810 10)
				(= local0 (knave new:))
				(local0
					x: 18
					y: 151
					loop: 6
					signal: (| (local0 signal:) $0800)
					init:
					stopUpd:
				)
				(knave init: stopUpd:)
				(richie init: stopUpd:)
				(if (proc806_8 mule)
					(mule init:)
				)
				(= ticks 12)
			)
			(1
				(gRgnMusic
					number: 102
					loop: 1
					init:
					play: self
					hold: 10
					fade: 127 60 8 0
					flags: (& (gRgnMusic flags:) $fffe)
				)
				(= ticks 6)
			)
			(2
				(Say 95 4 108 67 50 150 80 {Troubadour}) ; "Long and dangerous was the road, Enemies on all sides..."
			)
			(3
				(Say 95 5 108 67 50 150) ; "Hidden by the night he rode, Cloaked in merchant's guise."
			)
			(4
				(Say 95 6 108 67 50 150) ; "But in the realm of Austria King Leopold did reign..."
			)
			(5
				(Say 95 7 108 67 50 150) ; "He swore to capture Lionheart Or else to have him slain."
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(knave setCycle: Fwd setMotion: MoveTo 165 156)
				(if (proc806_8 mule)
					(mule setScript: trot)
				)
				(local0 setCycle: Fwd setMotion: MoveTo 138 154)
				(self setScript: gallop self)
			)
			(7
				(knave setCycle: 0 dispose:)
				(local0 setCycle: 0 dispose:)
				(richie
					loop: 2
					cel: 0
					posn: 148 160
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(8
				(richie setCycle: CT 3 -1 self)
			)
			(9
				(richie setCycle: End self)
			)
			(10
				(= ticks 120)
			)
			(11
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 820 10)
				(kingsHead init: setScript: sing)
				(leftHand init: setScript: wriggle1)
				(rightHand init: setScript: wriggle2)
				(= ticks 120)
			)
			(12
				(gRgnMusic release:)
				(Say 95 8 108 67 50 150 80 {Troubadour}) ; "Mighty oaths did Richard swear At this base treachery,..."
			)
			(13)
			(14
				(Say 95 9 108 67 50 150) ; "They bound him like a roaring lion To face his enemy."
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gRgnMusic fade: 60 12 8 0)
				(gCurRoom setScript: grovelYouWorm)
				(self dispose:)
			)
		)
	)
)

(instance trot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mule setCycle: Fwd setMotion: MoveTo 75 132 self)
			)
			(1
				(mule
					priority: 9
					signal: (| (mule signal:) $0010)
					setMotion: MoveTo 134 220 self
				)
			)
			(2
				(mule dispose:)
				(self dispose:)
			)
		)
	)
)

(instance gallop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(richie setCycle: Fwd setMotion: MoveTo 120 127 self)
			)
			(1
				(richie
					priority: 9
					signal: (| (richie signal:) $0010)
					setMotion: MoveTo 149 154 self
				)
			)
			(2
				(richie setCycle: 0)
				(= ticks 6)
			)
			(3
				(= register 1)
				(self dispose:)
			)
		)
	)
)

(instance grovelYouWorm of ZScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 825 10)
				(leoHead init: setScript: yodel)
				(leoHand init: setScript: point)
				(richieHand init: setScript: wriggle3)
				(guardHead init: stopUpd:)
				(= ticks 30)
			)
			(1
				(guardHead cel: 1 stopUpd:)
				(gRgnMusic
					number: 103
					loop: 1
					init:
					play: self
					fade: 127 60 8 0
					flags: (& (gRgnMusic flags:) $fffe)
				)
				(= ticks 6)
			)
			(2
				(Say 95 10 108 67 50 150 80 {Troubadour}) ; "King Leopold was filled with glee To have so rich a prize,..."
			)
			(3
				(Say 95 11 108 67 50 150) ; "His laughter filled the stoney hall, His greed rose to the skies."
			)
			(4
				(Say 95 12 108 67 50 150) ; "One hundred thousand golden marks On Richard's head he laid,..."
			)
			(5
				(Say 95 13 108 67 50 150) ; "And Lionheart his prisoner Until the ransom paid."
			)
			(6
				(guardHead cel: 0 stopUpd:)
				(leoHead setScript: 0)
				(Say 95 14 108 67 50 150) ; "`I have no fear,' King Richard said, My people love me well,..."
			)
			(7
				(Say 95 15 108 67 50 150) ; "They'll raise the ransom that you ask, And damn your soul to hell!'"
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom setScript: merrieMen)
				(self dispose:)
			)
		)
	)
)

(instance merrieMen of ZScript
	(properties)

	(method (init)
		(LoadMany 0 810 820 825)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 800 10)
				(bardsHead init: setScript: sing)
				(bardsHand init: setScript: strum)
				(bardsFingers init: setScript: riff)
				(bardsToes init: setScript: tap)
				(= ticks 60)
			)
			(1
				(gRgnMusic
					number: 104
					loop: 1
					init:
					play: self
					fade: 127 60 8 0
					flags: (& (gRgnMusic flags:) $fffe)
				)
				(= ticks 6)
			)
			(2
				(Say 95 16 108 67 50 150) ; "And when in England Prince John heard Of his brother's golden fee,..."
			)
			(3
				(Say 95 17 108 67 50 150) ; "He swore a dark unholy oath That he would ne'er go free."
			)
			(4
				(Say 95 18 108 67 50 150) ; "So the days have sorely passed And Lionheart does wait,..."
			)
			(5
				(Say 95 19 108 67 50 150) ; "As black Prince John and traitorous dogs Conspire to seal his fate."
			)
			(6
				(Say 95 20 108 67 50 150) ; "While Robin Hood in green Sherwood An outlaw's life does lead,..."
			)
			(7
				(Say 95 21 108 67 50 150) ; "Falsely charged by men corrupt, To satisfy their greed."
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Say 95 22 108 67 50 155) ; "At your side companions true, Little John is one,..."
				(johnnie init:)
				(frameJohn init:)
			)
			(9
				(alanD init: addToPic:)
				(frameAlan init: addToPic:)
				(Say 95 23 108 67 50 155) ; "...Alan-a-Dale the troubadour,..."
			)
			(10
				(muchie init: addToPic:)
				(frameMuch init: addToPic:)
				(Say 95 24 108 67 50 155) ; "...And Much the Miller's son."
			)
			(11
				(willie init: addToPic:)
				(frameWill init: addToPic:)
				(Say 95 25 108 67 50 155) ; "Will Scarlet with his good yew bow,..."
			)
			(12
				(tuckie init: addToPic:)
				(frameTuck init: addToPic:)
				(Say 95 26 108 67 50 155) ; "...Friar Tuck to pray amen,..."
			)
			(13
				(robbie init: addToPic:)
				(frameRobin init: addToPic:)
				(Say 95 27 108 67 50 155) ; "Bold Robin Hood to lead them all, And so we shall begin!"
			)
			(14
				(gRgnMusic fade: 60 30 3 1)
				(= ticks 60)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 140)
				(self dispose:)
			)
		)
	)
)

(instance sing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(= ticks (Random 120 240))
			)
			(2
				(if (proc806_8 client)
					(client setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(3
				(= ticks (Random 120 240))
			)
			(4
				(if (proc806_8 client)
					(client cel: 1)
				)
				(= ticks 6)
			)
			(5
				(if (proc806_8 client)
					(client cel: 0)
				)
				(= ticks (* 10 (Random 4 11)))
			)
			(6
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
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(if (proc806_8 client)
					(client cel: 1)
				)
				(= ticks 12)
			)
			(2
				(if (proc806_8 client)
					(client cel: 2)
				)
				(= ticks 18)
			)
			(3
				(if (proc806_8 client)
					(client cel: 0)
				)
				(= ticks 12)
			)
			(4
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(5
				(if (proc806_8 client)
					(client cel: 1)
				)
				(= ticks 18)
			)
			(6
				(if (proc806_8 client)
					(client cel: 0)
				)
				(= ticks 18)
			)
			(7
				(if (proc806_8 client)
					(client cel: 2)
				)
				(= ticks 12)
			)
			(8
				(if (proc806_8 client)
					(client setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(9
				(= ticks 24)
				(= state -1)
			)
		)
	)
)

(instance tap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 2)
				(= ticks 48)
			)
			(1
				(client cel: 1)
				(= ticks 6)
			)
			(2
				(client cel: 2)
				(= ticks 48)
			)
			(3
				(client cel: 1)
				(= ticks 6)
			)
			(4
				(client cel: 2)
				(= ticks 18)
			)
			(5
				(client cel: 1)
				(= ticks 12)
			)
			(6
				(client cel: 2)
				(= ticks 18)
			)
			(7
				(client cel: 1)
				(= ticks 12)
			)
			(8
				(client cel: 2)
				(= ticks 48)
			)
			(9
				(client cel: 1)
				(= ticks 6)
			)
			(10
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance wriggle1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 216)
			)
			(1
				(client cel: 0)
				(= ticks 12)
			)
			(2
				(client cel: 1)
				(= ticks 30)
			)
			(3
				(= ticks 6)
				(= state -1)
			)
		)
	)
)

(instance wriggle2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 216)
			)
			(1
				(client cel: 0)
				(= ticks 12)
			)
			(2
				(client cel: 1)
				(= ticks 30)
			)
			(3
				(= ticks 6)
				(= state -1)
			)
		)
	)
)

(instance wriggle3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 282)
			)
			(1
				(if (proc806_8 client)
					(client cel: 0)
				)
				(= ticks 12)
			)
			(2
				(if (proc806_8 client)
					(client cel: 1)
				)
				(= ticks 30)
			)
			(3
				(= ticks 6)
				(= state -1)
			)
		)
	)
)

(instance yodel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(client stopUpd:)
				(= ticks (* 6 (Random 1 2)))
			)
			(2
				(if (proc806_8 client)
					(client setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(3
				(client stopUpd:)
				(= ticks (* 6 (Random 1 2)))
			)
			(4
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(5
				(client stopUpd:)
				(= ticks (* 6 (Random 1 2)))
			)
			(6
				(if (proc806_8 client)
					(client setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(7
				(= ticks (* 6 (Random 1 2)))
			)
			(8
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(9
				(= ticks (* 6 (Random 1 2)))
			)
			(10
				(if (proc806_8 client)
					(client setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(11
				(= ticks (* 6 (Random 1 2)))
			)
			(12
				(if (proc806_8 client)
					(client cel: 1)
				)
				(= ticks 6)
			)
			(13
				(if (proc806_8 client)
					(client cel: 0)
				)
				(= ticks (* 10 (Random 4 11)))
			)
			(14
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance point of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc806_8 client)
					(client setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(client stopUpd:)
				(= ticks 270)
			)
			(2
				(if (proc806_8 client)
					(client setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(3
				(client stopUpd:)
				(= ticks 390)
			)
			(4
				(= ticks 24)
				(= state -1)
			)
		)
	)
)

(instance lastScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(gCurRoom newRoom: 140)
				(self dispose:)
			)
		)
	)
)

