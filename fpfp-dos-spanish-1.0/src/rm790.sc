;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Talker)
(use Scaler)
(use Osc)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm790 0
	proc790_1 1
)

(local
	local0 = 1
	local1 = 1
	local2
	local3 = 1
	local4 = 2
	local5
	local6
	local7
	[local8 50]
)

(procedure (proc790_1 param1 &tmp temp0 temp1)
	(for ((= temp0 1)) (< temp0 4) ((++ temp0))
		(for ((= temp1 59)) (< temp1 62) ((++ temp1))
			(Display
				param1
				dsFONT
				150
				dsALIGN
				alCENTER
				dsCOORD
				temp1
				(switch temp0
					(1
						(- local6 1)
					)
					(2 local6)
					(3
						(+ local6 1)
					)
				)
				dsCOLOR
				0
				dsWIDTH
				200
			)
		)
	)
	(Display param1 dsFONT 150 dsALIGN alCENTER dsCOORD 60 local6 dsCOLOR 41 dsWIDTH 200)
)

(class WrapMusic of List
	(properties
		wrapSound 0
		currentSound 0
		loopIt 0
		vol 127
		paused 0
	)

	(method (init param1)
		(Sounds eachElementDo: #check)
		(if (not wrapSound)
			(= wrapSound gGameMusic1)
		)
		(= loopIt param1)
		(= currentSound 0)
		(self add: &rest cue:)
	)

	(method (cue &tmp temp0 temp1 temp2)
		(cond
			((OneOf (wrapSound prevSignal:) -1 0)
				(= temp0 1)
				(cond
					((and (== loopIt -1) (== currentSound (- size 1)))
						(= temp0 -1)
					)
					((== currentSound size)
						(switch loopIt
							(1
								(= currentSound 0)
							)
							(else
								(self release: dispose:)
								(return)
							)
						)
					)
				)
				(if (> (= temp1 (self at: currentSound)) 1000)
					(-= temp1 1000)
					(= temp2 1)
				else
					(= temp2 0)
				)
				(wrapSound number: temp1 setLoop: temp0 flags: 1 play: vol self)
				(++ currentSound)
			)
			(paused
				(wrapSound pause:)
			)
			(else
				(= vol (wrapSound vol:))
			)
		)
	)

	(method (pause param1)
		(if (IsObject wrapSound)
			(if (and argc (not param1))
				(= paused 0)
				(wrapSound pause: 0 fade: vol 5 5 0)
			else
				(= paused 1)
				(wrapSound fade: 0 5 5 0)
			)
		)
	)

	(method (dispose param1)
		(wrapSound client: 0)
		(if (and argc param1)
			(super dispose:)
		else
			(self release:)
		)
	)
)

(instance rm790 of FPRoom
	(properties
		picture 420
		style 100
	)

	(method (init)
		(gGame handsOff:)
		(gTheIconBar disable:)
		(gGame setCursor: 996 1)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(WrapMusic init: 1 1110 1235 1675 1260)
		(Message msgGET 790 6 0 0 1 @local8)
		(gNarrator x: 20 y: 40 name: @local8 showTitle: 1)
		(super init:)
		(self setScript: sRunCredits 0 2)
	)

	(method (handleEvent event)
		(if (and local7 (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(event claimed: 1)
			(gGame setCursor: 999 1 198 175)
			(switch
				(Print
					posn: (proc0_16 50 20 50 50 50) 160
					addButton: 1 4 0 0 1 0 0 790 ; "Restore"
					addButton: 2 4 0 0 2 (proc0_16 43 58 55 60 60) 0 790 ; "Restart"
					addButton: 0 4 0 0 3 (proc0_16 103 162 125 120 120) 0 790 ; "Continue"
					addButton: 3 4 0 0 4 (proc0_16 179 220 179 179 179) 0 790 ; "Quit"
					init:
				)
				(0
					(gGameMusic1 pause: 0)
				)
				(1
					(gGame restore:)
					(gGameMusic1 pause: 0)
				)
				(2
					(gGame restart:)
					(gGameMusic1 pause: 0)
				)
				(3
					(= gQuit 1)
				)
			)
			(gGame setCursor: 996 1)
		)
	)

	(method (dispose)
		(super dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)
)

(instance sRunCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 120] temp120)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= local7 1)
				(Palette palSET_INTENSITY 0 256 100)
				(gCast eachElementDo: #stopUpd)
				(if (not local3)
					(crackSound play:)
					(= local3 0)
				)
				(= cycles 3)
			)
			(2
				(= local5 register)
				(= local6 (/ (- 200 (+ 30 (* register 10))) 2))
				(Message msgGET 790 1 0 0 local1 @temp0)
				(proc790_1 @temp0)
				(= seconds 1)
			)
			(3
				(+= local6 20)
				(= cycles 3)
			)
			(4
				(if (== local0 36)
					(= local4 3)
					(= local0 1)
				)
				(= temp120 local0)
				(Message msgGET 790 local4 0 0 temp120 @temp0)
				(proc790_1 @temp0)
				(if (> local5 1)
					(= cycles 2)
				else
					(= seconds 3)
				)
			)
			(5
				(++ local0)
				(+= local6 10)
				(if (-- local5)
					(self changeState: 4)
				else
					(switch (++ local1)
						(1
							(rm790 picture: 420)
							(LoadMany rsPIC 420)
							(= register 1)
						)
						(2
							(= register 1)
						)
						(3
							(rm790 picture: 750)
							(LoadMany rsPIC 750)
							(= register 1)
						)
						(4
							(= register 1)
						)
						(5
							(rm790 picture: 675)
							(LoadMany rsPIC 675)
							(= register 1)
						)
						(6
							(= register 1)
						)
						(7
							(rm790 picture: 235)
							(LoadMany rsPIC 235)
							(= register 1)
						)
						(8
							(= register 3)
						)
						(9
							(rm790 picture: 560)
							(LoadMany rsPIC 560)
							(= register 4)
						)
						(10
							(= register 1)
						)
						(11
							(= register 2)
						)
						(12
							(= local6 10)
							(rm790 picture: 730)
							(LoadMany rsPIC 730)
							(gEgo wearingGuns: 1)
							(freddy
								view: 730
								loop: 2
								x: 175
								y: 93
								init:
								stopUpd:
								setScale: Scaler 121 68 153 61
								setScript: sRunOuttake 0 1
							)
							(prop1
								view: 734
								loop: 1
								x: 79
								y: 17
								init:
								setPri: 10
								stopUpd:
							)
							(actor2
								view: 802
								loop: 0
								x: 103
								y: 100
								setScale: 0
								stopUpd:
								init:
							)
							(= register 10)
						)
						(13
							(= register 3)
						)
						(14
							(= local6 86)
							(= register 1)
						)
						(15
							(= local6 10)
							(rm790 picture: 720)
							(LoadMany rsPIC 720)
							(freddy
								view: 741
								loop: 2
								cel: 3
								x: 130
								y: 119
								init:
								setScale: Scaler 97 75 172 143
								setScript: sRunOuttake 0 2
							)
							(prop1
								view: 720
								loop: 3
								x: 107
								y: 100
								init:
								stopUpd:
							)
							(actor2
								view: 740
								loop: 2
								x: 90
								y: 126
								setPri: 11
								init:
								stopUpd:
								setScale: Scaler 97 75 172 143
							)
							(= register 9)
						)
						(16
							(= local6 86)
							(= register 1)
						)
						(17
							(= local6 10)
							(rm790 picture: 200)
							(LoadMany rsPIC 200)
							(gEgo wearingGuns: 0)
							(freddy
								view: 800
								setCycle: StopWalk -1
								x: 165
								y: 104
								init:
								stopUpd:
								setScale: Scaler 100 50 175 95
								setScript: sRunOuttake 0 3
							)
							(prop1
								view: 200
								loop: 0
								x: 136
								y: 64
								z: -2
								init:
								setCycle: Fwd
							)
							(actor2
								view: 201
								loop: 1
								x: 138
								y: 67
								init:
								setScale: Scaler 100 50 175 95
							)
							(= register 6)
						)
						(18
							(= register 12)
						)
						(19
							(rm790 picture: 260)
							(LoadMany rsPIC 260)
							(freddy
								view: 261
								loop: 7
								posn: 231 25
								init:
								setScale: 0
								setPri: 13
								stopUpd:
								setScript: sRunOuttake 0 4
							)
							(prop1
								view: 268
								x: 1
								y: 47
								z: 0
								setPri: 10
								init:
								setCycle: Fwd
							)
							(prop2 init: stopUpd: setCel: 3)
							(prop3 init: stopUpd: setPri: 15)
							(prop4 init: stopUpd:)
							(actor2
								view: 803
								x: 138
								y: 67
								init:
								setScale: Scaler 100 50 175 95
								ignoreActors:
								stopUpd:
								setHeading: 180
							)
							(= register 7)
						)
						(20
							(= local6 86)
							(= register 3)
						)
						(21
							(= register 2)
							(rm790 picture: 780)
							(self setScript: sShowText)
						)
						(else
							(rm790 picture: 420)
							(= local0 1)
							(= local1 1)
							(= local6 86)
							(= local3 1)
							(gCast eachElementDo: #dispose)
						)
					)
					(gCurRoom drawPic: (rm790 picture:))
					(crackSound play:)
					(if (not (OneOf local1 12 15 17 19 21))
						(self changeState: 0)
					)
				)
			)
		)
	)
)

(instance sShowText of Script
	(properties)

	(method (changeState newState &tmp [temp0 260])
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(= seconds 2)
			)
			(1
				(Message msgGET 791 5 0 0 1 @temp0) ; "This adventure game is a work of fiction and is protected under the law under the general heading of parody, which means we really hope we can get away with everything we said and did in the game. If not, we'll just fall back on the old "the people and events described herein bear no relation to any real or imagined people and events" loophole."
				(Display @temp0 dsFONT 150 dsALIGN alCENTER dsCOORD 30 10 dsCOLOR 41 dsWIDTH 250)
				(Message msgGET 791 5 0 0 2 @temp0) ; "A total of 34 animals were injured or maimed in the making of this game. After all, we wanted complete realism."
				(Display @temp0 dsFONT 150 dsALIGN alCENTER dsCOORD 30 100 dsCOLOR 41 dsWIDTH 250)
				(= seconds 20)
			)
			(2
				(WrapMusic pause:)
				(rm790 picture: 420)
				(gCurRoom style: 10 drawPic: 780)
				(= cycles 150)
			)
			(3
				(WrapMusic dispose:)
				(= cycles 150)
			)
			(4
				(WrapMusic init: 1 1110 1235 1675 1260)
				(gCurRoom style: 100 drawPic: (rm790 picture:))
				(= local0 1)
				(= local1 1)
				(= local6 86)
				(= local3 1)
				(= local4 2)
				(sRunCredits changeState: 0)
				(self dispose:)
			)
		)
	)
)

(instance sRunOuttake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 0)
				(= cycles 50)
			)
			(1
				(if (== register 2)
					(self setScript: sFight self)
				else
					(= cycles 2)
				)
			)
			(2
				(if (== register 4)
					((ScriptID 1817 47) modeless: 1) ; Madame
					((ScriptID 1800 49) modeless: 1) ; Freddy
					(Narrator modeless: 1)
				)
				(gMessager say: register 0 0 1 3 self 791)
			)
			(3
				(if (== register 1)
					(actor2 startUpd: setHeading: 180)
				)
				(= cycles 5)
			)
			(4
				(if (== register 1)
					(actor2 stopUpd:)
				)
				(= cycles 1)
			)
			(5
				(gMessager say: register 0 0 4 5 self 791)
			)
			(6
				(if (== register 3)
					(self setScript: sSrini self)
				else
					(gMessager say: register 0 0 6 10 self 791)
				)
			)
			(7
				(if (== register 3)
					(self changeState: 16)
				else
					(if (== register 1)
						(actor2 startUpd: setHeading: 90)
					)
					(= cycles 5)
				)
			)
			(8
				(if (== register 1)
					(actor2 stopUpd:)
				)
				(= cycles 1)
			)
			(9
				(gMessager say: register 0 0 11 12 self 791)
			)
			(10
				(if (== register 1)
					(actor2 startUpd: setHeading: 180)
				)
				(= cycles 5)
			)
			(11
				(if (== register 1)
					(actor2 stopUpd:)
				)
				(= cycles 1)
			)
			(12
				(gMessager say: register 0 0 13 15 self 791)
			)
			(13
				(if (== register 1)
					(actor2 startUpd: setHeading: 90)
				)
				(= cycles 5)
			)
			(14
				(if (== register 1)
					(actor2 stopUpd:)
				)
				(= cycles 1)
			)
			(15
				(cond
					((== register 3)
						(= cycles 2)
					)
					((== register 4)
						(self setScript: sMadame self)
					)
					(else
						(gMessager say: register 0 0 16 self 791)
					)
				)
			)
			(16
				(cond
					((== register 2)
						(freddy loop: 1 setCycle: End self)
						(actor2 setCycle: Beg)
					)
					((== register 4)
						(gMessager say: register 0 0 17 18 self 791) ; "This is ridiculous. I swear, I'll sue if something goes wrong. This is what happened to Margaret Hamilton, y'know."
					)
					(else
						(= cycles 2)
					)
				)
			)
			(17
				(if (== register 4)
					(freddy setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(18
				(if (== register 4)
					(fartSound play:)
					(freddy stopUpd:)
				)
				(= seconds 2)
			)
			(19
				(if (== register 4)
					(gMessager say: register 0 0 19 20 self 791) ; "|c0|OW!|c| Worker's comp! Worker's comp!"
				else
					(= cycles 2)
				)
			)
			(20
				(if (== register 4)
					((ScriptID 1817 47) modeless: 0) ; Madame
					((ScriptID 1800 49) modeless: 0) ; Freddy
					(Narrator modeless: 0)
				)
				(gCast eachElementDo: #stopUpd)
				(sRunCredits changeState: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actor2 loop: 2 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 3 0 0 6 7 self 791) ; "I didn't hear any Italian creeping in. I thought it was pretty good."
			)
			(2
				(actor2
					view: 801
					setCycle: StopWalk -1
					setStep: 7 2
					setSpeed: 4
					setMotion: MoveTo (actor2 x:) (+ (actor2 y:) 30) self
				)
			)
			(3
				(gMessager say: 3 0 0 8 self 791) ; "Antonio! Don't walk on the ants!"
			)
			(4
				(actor2
					setMotion: MoveTo (- (actor2 x:) 15) (- (actor2 y:) 5) self
				)
			)
			(5
				(actor2
					setMotion: MoveTo (+ (actor2 x:) 15) (+ (actor2 y:) 5) self
				)
			)
			(6
				(actor2
					setMotion: MoveTo (- (actor2 x:) 15) (- (actor2 y:) 5) self
				)
			)
			(7
				(gMessager say: 3 0 0 9 self 791) ; "Ants! Hah! 'Atsa what I think of your lousy ants!"
			)
			(8
				(actor2 setMotion: MoveTo -20 (actor2 y:) self)
			)
			(9
				(gMessager say: 3 0 0 10 self 791) ; "Mike, get Antonio's agent on the phone. Steve, get the rest of the programmers down here. Gil, take five."
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance sMadame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actor2 setPri: -1 setMotion: MoveTo 53 26 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actor2 view: 740 loop: 0 cel: (actor2 lastCel:))
				(= ticks 30)
				(freddy view: 741 loop: 0 setMotion: 0 setCycle: 0)
			)
			(1
				(actor2 setCycle: Osc 3 self)
				(freddy setCycle: Osc 3)
			)
			(2
				(actor2 loop: 1 setCycle: Osc 3 self)
				(freddy loop: 1 setCycle: Osc 2)
			)
			(3
				(freddy loop: 2 cel: 3 stopUpd:)
				(actor2 loop: 2 cel: 3 stopUpd:)
				(= cycles 3)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance prop1 of Prop
	(properties
		view 734
	)
)

(instance freddy of Actor
	(properties
		view 800
	)
)

(instance actor2 of Actor
	(properties
		view 800
	)
)

(instance prop2 of View
	(properties
		x 300
		y 60
		z 40
		view 260
		loop 4
	)
)

(instance prop3 of View
	(properties
		x 252
		y 79
		z -2
		view 260
		loop 2
	)
)

(instance prop4 of View
	(properties
		x 210
		y 60
		view 260
	)
)

(instance crackSound of FPSound
	(properties
		flags 1
		number 2912
	)
)

(instance fartSound of FPSound
	(properties
		flags 1
		number 2116
	)
)

