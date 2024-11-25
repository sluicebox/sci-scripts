;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use CycleBet)
(use BalloonTalker)
(use ADRoom)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm381 0
	offSrnT 1
	nellieT 4
	quibbleT 9
	vicarT 10
	pughT 13
	benT 16
)

(local
	[local0 200]
	[local200 4]
	local204
	local205
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	(Display param1 dsCOORD param2 param3 dsALIGN alCENTER dsFONT param5 dsCOLOR 7 dsWIDTH param4)
)

(instance rm381 of ADRoom
	(properties
		modNum 620
	)

	(method (init)
		(SetFlag 2)
		(gGame handsOff:)
		(if (== gPrevRoomNum 600)
			(group1 init: cycleSpeed: 6 setCycle: Fwd)
			(group2 init: cycleSpeed: 6 setCycle: Fwd)
			(self picture: 230)
			(gLongSong number: 110 hold: 1 setLoop: -1 play:)
			(UnLoad 128 807)
			(UnLoad 128 800)
			(UnLoad 128 790)
			(gCurRoom setScript: sRunOverHill)
		else
			(self picture: 99)
			(gCurRoom setScript: sCreditsRoll)
		)
		(super init:)
	)
)

(instance sRunOverHill of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 895 0) ; pepper
					init:
					setCycle: 0
					view: 237
					setLoop: 3
					cel: 0
					x: 77
					y: 144
					stopUpd:
				)
				((ScriptID 895 1) ; lockjaw
					init:
					setCycle: 0
					view: 237
					setLoop: 2
					cel: 0
					x: 111
					y: 161
					setScript: 0
					stopUpd:
				)
				(ben init: stopUpd:)
				(ima ignoreActors: 1 init:)
				(pugh ignoreActors: 1 init:)
				(percy ignoreActors: 1 init:)
				(= ticks 60)
			)
			(1
				(ima setCycle: End self)
				(pugh setCycle: End self)
				(percy setCycle: End self)
			)
			(2 0)
			(3 0)
			(4
				(ima stopUpd:)
				(pugh stopUpd:)
				(percy stopUpd:)
				(= cycles 1)
			)
			(5
				((ScriptID 2018 1) winX: 142 winY: 81 tailPosn: 3) ; imaText
				(gMessager say: 1 0 1 1 3 self) ; "Daddy! Daddy! Heeeeelp!"
			)
			(6
				(ima dispose:)
				(pugh dispose:)
				(percy dispose:)
				(gMessager say: 1 0 1 4 self) ; "Get out of here, you tyrants! Don't stop 'til you reach the Western frontier!"
			)
			(7
				(gMessager say: 1 0 1 5 14 self) ; "Ha ha ha! Look at 'em go! You'd BETTER run, Pugh-boy!"
			)
			(8
				(gMessager say: 1 0 2 1 2 self) ; "Uh-oh, Lockjaw! Do you feel what I feel?"
			)
			(9
				(gLongSong release:)
				(sFX number: 929 play:)
				((ScriptID 895 0) ; pepper
					view: 803
					loop: 2
					cel: 15
					x: 80
					y: 149
					setCycle: Beg self
				)
				((ScriptID 895 1) ; lockjaw
					view: 205
					loop: 0
					cel: 0
					x: 108
					y: 161
					setCycle: End self
				)
			)
			(10 0)
			(11
				(gMessager say: 1 0 2 3 4 self) ; "Lad? LAD?!?"
			)
			(12
				((ScriptID 895 0) hide:) ; pepper
				((ScriptID 895 1) hide:) ; lockjaw
				(= cycles 1)
			)
			(13
				(offSrnT x: 6 y: 90)
				(gMessager say: 1 0 2 5 self) ; "Goodbye, Walter!"
			)
			(14
				(offSrnT x: 6 y: 120)
				(gMessager say: 1 0 2 6 self) ; "Goodbye, Marley!"
			)
			(15
				(offSrnT x: 6 y: 100)
				(gMessager say: 1 0 2 7 self) ; "Goodbye, Ed!"
			)
			(16
				(offSrnT x: 6 y: 80)
				(gMessager say: 1 0 2 8 self) ; "Goodbye, Dan!"
			)
			(17
				(offSrnT x: 6 y: 110)
				(gMessager say: 1 0 2 9 self) ; "Goodbye, Ezra..."
			)
			(18
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sCreditsRoll of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< state 5) (== (gCurRoom curPic:) 155))
			(Palette palANIMATE 64 235 -1)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame setCursor: 996)
				(gTheIconBar disable:)
				(SetFlag 77)
				((ScriptID 0 9) doit:) ; statusCode
				(extra init: hide:)
				(if (or (== gPrevRoomNum 100) (not (gLongSong handle:)))
					(gLongSong number: 110 setLoop: -1 play:)
				)
				(if register
					(= local204 22)
					(= register 22)
				)
				(= ticks 60)
			)
			(1
				(if (== local204 26)
					(= local205 4115)
				else
					(= local205 2510)
				)
				(if (Message msgGET 620 1 0 1 (++ local204) @local0)
					(if (== local204 27)
						(gCurRoom drawPic: 155 10)
					else
						(gCurRoom drawPic: 99 (Random 11 14))
					)
					(TextSize @local200 @local0 local205)
					(localproc_0
						@local0
						(- 160 (/ [local200 3] 2))
						(- 100 (/ [local200 2] 2))
						[local200 3]
						local205
					)
					(= ticks 10)
				else
					(+= state 3)
					(= seconds 2)
				)
			)
			(2
				(if (< (Random 1 100) 50)
					(= temp0 35)
				else
					(= temp0 275)
				)
				(switch (++ register)
					(1
						(extra view: 121 x: 270 y: 189 setLoop: 3 cel: 0 show:)
					)
					(2
						(extra view: 143 x: 300 y: 189 setLoop: 0 cel: 0 show:)
					)
					(3
						(extra
							view: 135
							x: temp0
							y: 189
							setLoop: 2
							cel: 0
							show:
						)
					)
					(4
						(extra view: 305 x: 30 y: 189 setLoop: 1 cel: 0 show:)
					)
					(5
						(extra view: 611 x: 31 y: 195 setLoop: 1 cel: 0 show:)
					)
					(6
						(extra
							view: 135
							x: temp0
							y: 189
							setLoop: 5
							cel: 0
							show:
						)
					)
					(7
						(extra view: 140 x: 291 y: 189 setLoop: 2 cel: 0 show:)
					)
					(8
						(extra view: 213 x: 33 y: 180 setLoop: 4 cel: 0 show:)
					)
					(9
						(extra
							view: 215
							x: temp0
							y: 180
							setLoop: 0
							cel: 0
							show:
						)
					)
					(10
						(extra
							view: 838
							x: temp0
							y: 189
							setLoop: 4
							cel: 0
							show:
						)
					)
					(11
						(extra view: 242 x: 16 y: 180 setLoop: 1 cel: 0 show:)
					)
					(12
						(extra
							view: 227
							x: temp0
							y: 189
							setLoop: 2
							cel: 0
							show:
						)
					)
					(13
						(extra
							view: 251
							x: temp0
							y: 189
							setLoop: 3
							cel: 0
							show:
						)
					)
					(14
						(extra
							view: 808
							x: temp0
							y: 183
							setLoop: 2
							cel: 0
							show:
						)
					)
					(15
						(extra
							view: 217
							x: temp0
							y: 138
							setLoop: 4
							cel: 0
							show:
						)
					)
					(16
						(extra
							view: 127
							x: temp0
							y: 189
							setLoop: 3
							cel: 0
							show:
						)
					)
					(17
						(extra
							view: 382
							x: temp0
							y: 189
							setLoop: 3
							cel: 0
							show:
						)
					)
					(18
						(extra
							view: 382
							x: temp0
							y: 189
							setLoop: 1
							cel: 0
							show:
						)
					)
					(19
						(extra
							view: 382
							x: temp0
							y: 189
							setLoop: 4
							cel: 0
							show:
						)
					)
					(20
						(extra view: 384 setLoop: 3 x: 63 y: 203 cel: 0 show:)
					)
					(21
						(extra
							view: 386
							x: temp0
							y: 189
							setLoop: 3
							cel: 0
							show:
						)
					)
					(22
						(extra view: 384 x: 67 y: 189 setLoop: 5 cel: 0 show:)
					)
					(23
						(extra
							view: 810
							x: temp0
							y: 189
							setLoop: 0
							cel: 0
							show:
						)
					)
					(24
						(extra view: 814 x: 270 y: 189 setLoop: 1 cel: 0 show:)
					)
					(25
						(extra
							view: 613
							setLoop: 1
							x: 250
							y: 195
							setCel: 255
							show:
						)
					)
					(26
						(extra view: 885 x: 20 y: 133 setLoop: 1 cel: 0 show:)
					)
				)
				(= ticks 30)
			)
			(3
				(switch register
					(3
						(extra setCycle: CT 11 1)
					)
					(4
						(extra setCycle: CycleBet 1 8 2)
					)
					(10
						(extra setCycle: Fwd)
					)
					(14
						(extra setCycle: End)
					)
					(16
						(extra setCycle: End)
					)
					(17
						(extra setCycle: Fwd)
					)
					(18
						(extra setCycle: End)
					)
					(23
						(extra setCycle: 0)
					)
					(24
						(extra setCycle: CycleBet 0 255 2)
					)
					(25
						(extra setCycle: Beg)
					)
					(else
						(extra setCycle: End)
					)
				)
				(= seconds 6)
			)
			(4
				(Graph grFILL_BOX 0 0 189 319 1 0 -1 -1)
				(Graph grUPDATE_BOX 0 0 189 319 1)
				(-= state 4)
				(extra hide:)
				(= ticks 20)
			)
			(5
				(gCurRoom drawPic: 99 9)
				(gLongSong fade:)
				(= cycles 2)
			)
			(6
				(offSrnT winX: 42 winY: 129 tailPosn: 1)
				(extra
					view: 393
					setLoop: 0
					cel: 0
					x: 215
					y: 180
					setPri: 15
					show:
					setCycle: End
				)
				((= register (View new:))
					view: 393
					setLoop: 1
					cel: 1
					x: 290
					y: 177
					setPri: 15
					init:
					stopUpd:
				)
				(gMessager say: 1 0 4 1 self 620) ; "We saw the crowd! Is this the General's Ball?"
			)
			(7
				(= seconds 3)
			)
			(8
				(= gQuit 1)
			)
		)
	)
)

(instance ima of Actor
	(properties
		x 104
		y 95
		view 233
	)
)

(instance pugh of Actor
	(properties
		x 146
		y 88
		view 233
		loop 1
	)
)

(instance percy of Actor
	(properties
		x 119
		y 93
		view 233
		loop 2
	)
)

(instance ben of Actor
	(properties
		x 67
		y 163
		view 237
		loop 4
		signal 1
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 8)
		(super doVerb: theVerb)
	)
)

(instance group1 of Prop
	(properties
		x 25
		y 134
		view 237
	)
)

(instance group2 of Prop
	(properties
		x 48
		y 117
		view 237
		loop 1
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance extra of Prop
	(properties
		view 613
		priority 15
		signal 24592
	)
)

(instance offSrnT of BalloonTalker
	(properties
		x 6
		y 114
		talkWidth 150
		tailPosn 3
	)
)

(instance nellieT of BalloonTalker
	(properties
		x 43
		y 82
		talkWidth 150
		tailPosn 3
	)
)

(instance quibbleT of BalloonTalker
	(properties
		x 30
		y 51
		talkWidth 150
		tailPosn 3
	)
)

(instance vicarT of BalloonTalker
	(properties
		x 6
		y 59
		talkWidth 150
		tailPosn 3
	)
)

(instance benT of BalloonTalker
	(properties
		x 64
		y 129
		talkWidth 150
	)
)

(instance pughT of BalloonTalker
	(properties
		x 16
		y 59
		talkWidth 150
		tailPosn 1
	)
)

