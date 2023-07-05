;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use PPath)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm038 0
	Jack 1
	Kayleigh 2
	Keith 3
	Clarice 4
	Bobby 5
)

(local
	local0
	local1
	local2
	[local3 7] = [191 107 147 128 209 199 -32768]
	[local10 11] = [191 107 128 125 96 128 92 136 93 143 -32768]
	[local21 13] = [93 143 92 136 96 128 128 125 150 132 209 199 -32768]
	local34
	[local35 32] = [1 2 3 4 5 6 7 8 9 10 11 10 9 8 7 6 5 4 3 2 1 0 1 2 3 4 5 6 5 4 3 -32768]
)

(instance rm038 of Rm
	(properties
		noun 17
		picture 38
	)

	(method (init &tmp temp0)
		(= local34 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 105 103 81 111 0 64 0 0 319 0 319 189 290 189 0 189 0 70 73 113 58 117 58 152 70 152 82 140 101 131 119 131 130 139 155 139 155 148 145 154 203 154 149 125 150 118 157 114 170 112 184 103 178 100 138 119
					yourself:
				)
		)
		(windoe init:)
		(if (== global211 32)
			(= global211 33)
		)
		(if (OneOf global211 33 74)
			(jack init:)
			(chair init:)
		else
			(chairs onMeCheck: 2050)
		)
		(barback init:)
		(barpainting init:)
		(booth init:)
		(bullcinch init:)
		(chairs init:)
		(BRFloor init:)
		(stools init:)
		(table init:)
		(plant init:)
		(BRSign init:)
		(bar init:)
		(bar1 init: setScript: drinking 0 bar1)
		(bar2 init: setScript: (drinking new:) 0 bar2)
		(bar3 init: setScript: doBar3)
		(bartender init: looper: (Grooper new:) setScript: genTend)
		(booth1 init: setScript: doBooth)
		(booth2 init:)
		(bottle init:)
		(gCurRoom setScript: comeIn)
		(super init:)
		(kim init: setScript: servem)
		(gLongSong number: 370 loop: -1 play:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 4)
				(gCurRoom setScript: goAway)
			)
		)
	)

	(method (dispose)
		(DisposeScript 315)
		(DisposeScript 310)
		(= gUseSortedFeatures local34)
		(super dispose:)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo init: posn: 44 97 setMotion: MoveTo 78 116 self)
				(if (not (OneOf global211 33 74))
					(++ state)
				)
			)
			(1
				(gMessager say: 23 0 1 0 self) ; "You see your friend, Jack Cobb, sitting at the table. You've noticed that he's been depressed and distracted for days."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 44 97 self)
			)
			(1
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance keith of Actor
	(properties
		x 44
		y 97
		noun 10
		view 315
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (>= global211 74)
					(gMessager say: 10 4 13) ; "Leave Keith alone. You have more important things to do."
				else
					(gMessager say: 10 4 8) ; MISSING MESSAGE
				)
			)
			(2 ; Talk
				(if (>= global211 74)
					(gMessager say: 10 2 14) ; "It sounded important, Sonny. You'd better get to Morgan's office right now."
				else
					(gMessager say: 10 2 8) ; "Okay, I'll switch back with you..."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jack of Actor
	(properties
		x 114
		y 143
		z 19
		noun 9
		view 326
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (>= global211 74)
					(gMessager say: 9 1 10) ; "Oh, there's Jack."
				else
					(gMessager say: 9 1 4) ; "It's your old friend, Jack Cobb."
				)
			)
			(4 ; Do
				(if (>= global211 74)
					(gMessager say: 9 4 10) ; "You gently tap Jack on the shoulder."
				else
					(gMessager say: 9 4 4) ; "You give Jack a friendly pat on the shoulder."
				)
			)
			(2 ; Talk
				(cond
					((>= global211 74)
						(cond
							((not local1)
								(gMessager say: 23 0 11) ; "Hey, Sonny, why don' you siddown? I don't wanna strain my neck lookin' up at ya."
							)
							(local2
								(gCurRoom setScript: theDribble)
							)
							(else
								(gMessager say: 9 2 10) ; "Hi, Jack! Good news, buddy. We caught the bastard who was selling to Kathy."
								(= local2 1)
							)
						)
					)
					((not local1)
						(gMessager say: 23 0 3) ; "Have a seat, buddy."
					)
					((IsFlag 166)
						(gMessager say: 9 2 8) ; "You'd better go, Sonny. You know how mad Dooley gets if you're late."
					)
					((== global211 34)
						(gCurRoom setScript: surprise)
					)
					(else
						(gCurRoom setScript: wish)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kim of Actor
	(properties
		x 156
		y 111
		noun 26
		view 312
		loop 1
	)

	(method (dispose)
		(if looper
			(looper dispose:)
		)
		(super dispose:)
	)
)

(instance bar1 of Prop
	(properties
		x 239
		y 152
		noun 4
		view 314
		cel 5
		priority 9
		signal 16400
		detailLevel 1
	)
)

(instance bar2 of Prop
	(properties
		x 213
		y 132
		noun 4
		view 323
		cel 6
		priority 8
		signal 16400
		detailLevel 1
	)
)

(instance bar3 of Actor
	(properties
		x 191
		y 134
		noun 4
		view 318
		priority 7
		signal 16400
		detailLevel 1
	)
)

(instance bartender of Actor
	(properties
		x 205
		y 120
		noun 5
		view 305
		cel 3
		priority 6
		signal 16
	)

	(method (dispose)
		(if looper
			(looper dispose:)
		)
		(super dispose:)
	)
)

(instance booth1 of Prop
	(properties
		x 164
		y 105
		noun 7
		view 309
		loop 1
		cel 6
		priority 2
		signal 20496
		detailLevel 1
	)
)

(instance booth2 of Prop
	(properties
		x 134
		y 112
		noun 7
		view 306
		signal 20480
		detailLevel 1
	)
)

(instance dancer of Actor
	(properties
		x 34
		y 100
		view 321
		cel 8
		signal 16384
		cycleSpeed 8
		moveSpeed 8
	)
)

(instance bottle of View
	(properties
		x 217
		y 86
		view 305
		loop 6
	)
)

(instance windoe of Feature
	(properties
		noun 1
		onMeCheck 16384
	)
)

(instance chair of Feature
	(properties
		noun 8
		onMeCheck 2
	)

	(method (facingMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sitDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 133 140 self)
			)
			(1
				(gEgo setMotion: MoveTo 129 145 self)
			)
			(2
				(gEgo
					view: 325
					setLoop: 0
					cel: 0
					setPri: 11
					posn: 130 150
					setCycle: End self
				)
				(if (or (< global211 33) (>= global211 37))
					(++ state)
				)
			)
			(3
				(gMessager say: 24 4 4 0 self) ; "You sit down with Jack. It's nice to have a few minutes to talk with him before the party, you think to yourself."
			)
			(4
				(= local1 1)
				(gEgo looper: 0 setScript: waitToStand)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance waitToStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff 1)
				(= register (gEgo mover:))
				(if (not (gEgo mover:))
					(Prints {no mover!})
				)
				(gEgo mover: 0 posn: 129 145 setLoop: 0)
				(gEgo
					cel: (gEgo lastCel:)
					cycleSpeed: 10
					setCycle: Beg self
				)
			)
			(2
				(NormalEgo 1 2)
				(gEgo
					setPri: 11
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 133 140 self
				)
			)
			(3
				(gEgo
					setPri: -1
					setMotion: register (register finalX:) (register finalY:)
				)
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (not state) (gEgo mover:))
			(self cue:)
		)
	)
)

(instance wish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 9 2 2 0 self) ; "Hey, Jack! Happy birthday, man."
			)
			(1
				(jack setCycle: End self)
			)
			(2
				(self dispose:)
				(= global211 34)
				(HandsOn)
			)
		)
	)
)

(instance sad of Sound
	(properties
		priority 15
		loop -1
	)
)

(instance theDribble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 9 2 12 0 self) ; "We caught the creep who was dealing to Kathy, Jack. He's a slimy little punk named Donald P. Colby. We've got him, Jack. His eggs are gonna fry."
			)
			(1
				(keith setScript: keithEnter self)
			)
			(2
				(gMessager say: 23 0 13 0 self) ; "Sonny! Sonny, I need to talk to you!"
			)
			(3
				(= global211 76)
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance keithEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(keith
					init:
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 81 152 self
				)
				(= ticks 120)
			)
			(1
				(keith setPri: 10)
			)
			(2
				(keith view: 316 setLoop: 0 cel: 0 posn: 92 152)
				(= seconds 2)
			)
			(3
				(keith setCycle: CT 2 1 self)
			)
			(4
				(= ticks (keith cycleSpeed:))
			)
			(5
				(keith setPri: 11 setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance danceCues of Script
	(properties)

	(method (doit))

	(method (changeState newState)
		(switch (= state newState)
			(1
				(client cue:)
			)
			(else
				(dancer cel: (WordAt @local35 register))
				(++ register)
				(if (== (WordAt @local35 register) -32768)
					(self dispose:)
				)
			)
		)
	)
)

(instance drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 30))
			)
			(1
				(client setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				((= register (tend new:))
					register: client
					client: bartender
					caller: self
				)
				(if (== (bartender script:) genTend)
					(register next: genTend)
					(bartender setScript: register)
				else
					(register next: ((bartender script:) next:))
					((bartender script:) next: register)
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(client setLoop: 0 cel: 0 setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance tend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						(+ (register x:) 15)
						(+ (register y:) -10)
						self
				)
			)
			(1
				(bartender loop: 5)
				(= seconds 3)
			)
			(2
				(bartender setMotion: MoveTo 240 130 self)
			)
			(3
				(bartender view: 305 setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						(+ (register x:) 15)
						(+ (register y:) -10)
						self
				)
			)
			(5
				(bartender view: 305 setLoop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(6
				(= ticks 15)
			)
			(7
				(bartender setCycle: CT 0 -1 self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance tendKim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 205 120 self
				)
			)
			(1
				(bartender view: 305 setLoop: 0 cel: 0)
				(= seconds 2)
			)
			(2
				(bartender setCycle: End self)
			)
			(3
				(= ticks 44)
			)
			(4
				(bartender loop: 1 setCycle: End self)
				(= ticks 8)
			)
			(5
				(bottle hide:)
			)
			(6
				(bottle show: ignoreActors: 1 addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance watchIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 205 120 self
				)
			)
			(1
				(bartender
					signal: (| (bartender signal:) $0100)
					view: 305
					setLoop: 3
					cel: 0
					stopUpd:
				)
				(bar1 signal: (| (bar1 signal:) $0100) stopUpd:)
				(bar2 signal: (| (bar2 signal:) $0100) stopUpd:)
				(gEgo signal: (| (gEgo signal:) $0100) stopUpd:)
			)
			(2
				(bartender signal: (& (bartender signal:) $feff) startUpd:)
				(bar1 signal: (& (bar1 signal:) $feff) startUpd:)
				(bar2 signal: (& (bar2 signal:) $feff) startUpd:)
				(gEgo signal: (& (gEgo signal:) $feff) startUpd:)
				(self dispose:)
			)
		)
	)
)

(instance genTend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 205 120 self
				)
			)
			(1
				(bartender view: 305 setLoop: (Random 2 3) cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 241 125 self
				)
			)
			(3
				(bartender view: 305 setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 4)
			)
			(5
				(bartender
					view: 320
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 264 133
				)
				(= seconds (Random 10 30))
				(= state -1)
			)
		)
	)
)

(instance doBar3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(bar3 setCycle: End self)
			)
			(2
				(bar3 ignoreActors: 1 addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance doBooth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(booth1 stopUpd:)
				(booth2 stopUpd:)
				(= seconds (Random 10 30))
			)
			(1
				((if (< (Random 10 20) 15) booth1 else booth2)
					startUpd:
					setLoop: (/ (Random 1 4) 3)
					setCycle: CT 0 1 self
				)
				(= state -1)
			)
		)
	)
)

(instance cake of View
	(properties
		x 114
		y 133
		noun 27
		view 313
		loop 9
		priority 12
		signal 16
	)
)

(instance cakeFeat of Feature
	(properties
		x 114
		y 233
		z 100
		nsTop 129
		nsLeft 103
		nsBottom 137
		nsRight 125
	)

	(method (doVerb theVerb)
		(cake doVerb: theVerb)
	)
)

(instance Jack of Talker
	(properties
		x 200
		y 80
		view 1329
		cel 1
		talkWidth 150
		textX -185
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 jMouth &rest)
	)
)

(instance jMouth of Prop
	(properties
		nsTop 39
		nsLeft 32
		view 1329
		loop 1
	)
)

(instance Kayleigh of Narrator
	(properties
		showTitle 1
		back 15
	)
)

(instance Keith of Narrator
	(properties
		x 30
		y 40
		showTitle 1
		back 43
	)
)

(instance Clarice of Narrator
	(properties
		x 30
		y 154
		showTitle 1
		back 23
	)
)

(instance Bobby of Narrator
	(properties
		showTitle 1
		back 27
	)
)

(instance barback of Feature
	(properties
		x 213
		y 103
		noun 3
		onMeCheck 32
	)
)

(instance barpainting of Feature
	(properties
		x 239
		y 110
		noun 20
		onMeCheck 64
	)
)

(instance booth of Feature
	(properties
		x 136
		y 90
		noun 6
		onMeCheck 128
	)
)

(instance bullcinch of Feature
	(properties
		x 198
		y 93
		noun 21
		onMeCheck 512
	)
)

(instance chairs of Feature
	(properties
		x 112
		y 143
		noun 8
		onMeCheck 2048
	)
)

(instance BRFloor of Feature
	(properties
		x 166
		y 74
		noun 22
		onMeCheck 8192
	)
)

(instance stools of Feature
	(properties
		x 165
		y 125
		noun 15
		onMeCheck 4096
	)
)

(instance table of Feature
	(properties
		x 114
		y 152
		noun 18
		onMeCheck 1024
	)
)

(instance plant of Feature
	(properties
		x 163
		y 75
		noun 14
		onMeCheck 16
	)
)

(instance BRSign of Feature
	(properties
		x 124
		y 88
		noun 19
		onMeCheck 8
	)
)

(instance bar of Feature
	(properties
		x 203
		y 125
		noun 2
		onMeCheck 256
	)
)

(instance surprise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 9 2 5 0 self) ; "Jack, buddy, you look worried. Is something bothering you? Other than getting old, of course!"
			)
			(1
				(jack setCycle: Beg self)
			)
			(2
				(= register (gLongSong vol:))
				(gLongSong fade: 70 5 4 0 self)
			)
			(3
				(gLongSong pause: 1)
				(sad owner: rm038 init: number: 371 flags: 1 play:)
				(gMessager say: 9 2 16 0 self) ; "I...Sonny, I think Kathy's on drugs. My little girl. I just can't believe it."
			)
			(4
				(gMessager say: 9 2 17 1 self) ; "Sonny, she's been having nosebleeds all the time. She steals money from us. She was out all night last night, and I...I just...Oh, God, my little girl..."
			)
			(5
				(jack setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(sad number: 372 play:)
				(= ticks 30)
			)
			(7
				(gMessager say: 9 2 17 2 self) ; "Saddened and embarrased, you give Jack a moment to gain his composure. This also allows you to gather your own thoughts; you're not very good with expressing yourself sometimes."
			)
			(8
				(jack setLoop: 3 cel: 0 setCycle: End self)
			)
			(9
				(= ticks 60)
			)
			(10
				(gMessager say: 9 2 18 0 self) ; "Anyway, I don't know what to do. I try to talk to her, and she just screams at me and slams the door in my face."
			)
			(11
				(sad fade:)
				(gLongSong pause: 0 fade: register 5 4 0)
				(servem register: 1 cue:)
				(watchIt register: client caller: self)
				(if (== (bartender script:) genTend)
					(watchIt next: genTend)
					(bartender setScript: watchIt)
				else
					(watchIt next: ((bartender script:) next:))
					((bartender script:) next: watchIt)
				)
				(keith
					init:
					posn: 48 100
					setLoop: 1
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setPri: -1
					setMotion: MoveTo 67 127 self
				)
			)
			(12
				(= seconds 2)
			)
			(13
				(gMessager say: 23 0 4 0 self) ; "Hey hey hey, where's the birthday boy! There he is! Jack, dude! Happy day!"
			)
			(14
				(keith setLoop: 0 setMotion: MoveTo 69 150 self)
			)
			(15
				(if (and (!= (keith x:) 69) (!= (keith y:) 150))
					(-= state 2)
					(= cycles 2)
				else
					(keith setLoop: 3 setCel: 7)
					(= ticks 5)
				)
			)
			(16
				(if (and (!= (keith x:) 69) (!= (keith y:) 150))
					(-= state 3)
					(= cycles 2)
				else
					(keith
						view: 316
						setLoop: 0
						cel: 0
						posn: 92 152
						setCycle: End self
					)
				)
			)
			(17
				(gLongSong fade:)
				(= seconds 4)
			)
			(18
				(self setScript: dance self)
			)
			(19
				(if (not local0)
					(-- state)
				)
				(= cycles 2)
			)
			(20
				(kim
					view: 313
					init:
					looper: (Grooper new:)
					setCycle: SyncWalk
					posn: 145 193
					setMotion: MoveTo 129 161 self
				)
			)
			(21
				(= cycles 3)
			)
			(22
				(gMessager say: 23 0 7 0 self) ; "Happy birthday, Jack!"
			)
			(23
				(cake ignoreActors: 1 addToPic:)
				(cakeFeat init:)
				(kim view: 319 setMotion: MoveTo 142 193 self)
			)
			(24
				(kim dispose:)
				(self dispose:)
				(watchIt cue:)
				(SetScore 166 2)
				(= global211 36)
				(HandsOn)
			)
		)
	)
)

(instance dance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(booth1 ignoreActors: 1 addToPic:)
				(booth2 ignoreActors: 1 addToPic:)
				(keith ignoreActors: 1 addToPic:)
				(self setScript: danceCues self)
				(sad number: 373 loop: -1 flags: 0 play: danceCues)
			)
			(1
				(dancer
					init:
					setCycle: Walk
					setPri: 3
					setMotion: MoveTo 68 124 self
				)
			)
			(2
				(dancer setPri: -1 setMotion: MoveTo 88 138 self)
			)
			(3
				((= register (Actor new:))
					view: 321
					setLoop: 4
					setPri: 12
					posn: (+ (dancer x:) -3) (+ (dancer y:) -46)
					init:
					yStep: 3
					setMotion: MoveTo 100 10 self
				)
				(dancer setLoop: 3 cel: 7)
			)
			(4
				(register dispose:)
				(dancer cel: 6)
				(= ticks 77)
			)
			(5
				(dancer cel: 7)
				(= ticks 19)
			)
			(6
				(dancer view: 322 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(= ticks 190)
			)
			(8
				(dancer setCycle: Beg self)
			)
			(9
				(dancer
					loop: 1
					cel: 0
					cycleSpeed: 15
					setCycle: End self
					xStep: 1
					yStep: 1
					moveSpeed: 20
					setMotion: MoveTo 83 128
				)
			)
			(10
				(= ticks 12)
			)
			(11
				(dancer
					xStep: 3
					yStep: 2
					setMotion: 0
					loop: 2
					setCycle: End self
				)
			)
			(12
				(= ticks 9)
			)
			(13
				(dancer setCycle: Beg self)
			)
			(14
				(= ticks 9)
			)
			(15
				(dancer loop: 1 cel: 0 setCycle: End self)
			)
			(16
				(dancer loop: 3 cel: 0)
				(if (not script)
					(= cycles 1)
				)
			)
			(17
				(dancer cel: 4 setCycle: Beg self)
			)
			(18
				(dancer
					loop: 1
					cel: 0
					setCycle: End self
					setMotion: MoveTo 98 141
				)
			)
			(19
				(dancer cycleSpeed: 11 setCycle: End self)
			)
			(20
				(dancer loop: 2 cycleSpeed: 12 setCycle: End self)
			)
			(21
				(= ticks 9)
			)
			(22
				(dancer setCycle: Beg self)
			)
			(23
				(gMessager say: 23 0 6 0 self) ; "Happy birthday, Jack, baby!"
			)
			(24
				(Load rsVIEW 321)
				(dancer loop: 4 cel: 0 cycleSpeed: 9 setCycle: End self)
			)
			(25
				(dancer
					view: 321
					setLoop: 2
					setCycle: Walk
					moveSpeed: 10
					cycleSpeed: 10
					setMotion: MoveTo 34 100 self
				)
			)
			(26
				(dancer dispose:)
				(sad fade: 0 5 4 0 self)
			)
			(27
				(gLongSong number: 370 play: setVol: 0 fade: 127 25 5 0)
				(sad dispose:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance servem of Script
	(properties
		start 5
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kim view: 312 loop: 0 cel: 0 setCycle: CT 6 1)
				(tendKim register: client caller: self)
				(if (== (bartender script:) genTend)
					(tendKim next: genTend)
					(bartender setScript: tendKim)
				else
					(tendKim next: ((bartender script:) next:))
					((bartender script:) next: tendKim)
				)
			)
			(1)
			(2
				(kim view: 319 setCycle: SyncWalk)
				(if (== register 2)
					(kim setMotion: MoveTo 156 111 self)
				else
					(kim
						setMotion: PPath (if register @local3 else @local10) self
					)
				)
			)
			(3
				(kim dispose:)
			)
			(4
				(kim view: 319 looper: (Grooper new:) setCycle: SyncWalk)
				(switch (Random 2 3)
					(3
						(kim setMotion: PPath @local10 2 0 self)
						(= state -1)
					)
					(2
						(kim setMotion: PPath @local21 self)
						(= state 2)
					)
				)
			)
			(5
				(kim view: 312 setCycle: CT 6 1 self)
			)
			(6
				(kim setCycle: CT 4 -1 self)
			)
			(7
				(if (not (gEgo mover:))
					(-= state (if (< (Random 1 20) 2) 3 else 1))
				)
				(= ticks 6)
			)
			(8
				(kim view: 319 setCycle: SyncWalk)
				(kim setMotion: MoveTo 191 107 self)
				(= state -1)
			)
		)
	)
)

