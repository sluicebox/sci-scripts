;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm570 0
	Sis_Inny 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(onesCtr cel: (mod gNowServingNumber 10))
	(tensCtr cel: (/ gNowServingNumber 10))
	(if (gTalkers isEmpty:)
		(countSnd play:)
	)
)

(instance rm570 of SQRoom
	(properties
		noun 1
		picture 570
	)

	(method (init)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -10 138 -10 140 310 140 310 138
					yourself:
				)
		)
		(gEgo init: normalize: setScaler: Scaler 100 63 126 95)
		(switch gPrevRoomNum
			(580
				(gEgo
					posn: 202 91
					hide:
					setScaler: Scaler 100 71 138 93
					setScript: egoEntersFrom580
				)
				(fileWindow loop: 2 cel: 0 posn: 18 128 init:)
			)
			(else
				(gEgo posn: 0 138 setScript: egoEnters570)
				(fileCabinet init: approachVerbs: 4) ; Do
				(if (and (not (IsFlag 57)) (not (gEgo has: 75))) ; Number_3_Cord
					(number3 init: approachVerbs: 4) ; Do
				)
			)
		)
		(if (IsFlag 182)
			(gizmo init:)
			(localproc_0)
			(tinyTensCtr cel: (tensCtr cel:) init:)
			(tinyOnesCtr cel: (onesCtr cel:) init:)
		else
			(tensCtr init:)
			(onesCtr init:)
		)
		(printer init: approachVerbs: 126 124 125 123 127) ; Beleaux_Record, Nigel_Record, Project_Record, Sape_Record, Icky_Record
		(ringer init: hide:)
		(siFan init: hide:)
		(siClock init: hide:)
		(siRadio init: hide:)
		(siTrash init: hide:)
		(sisInny init: approachVerbs: 2 133 setScript: workin) ; Talk, Number_3_Cord
		(bell init: approachVerbs: 4) ; Do
		(trash init:)
		(radio init:)
		(clock init:)
		(fan init:)
		(screenSaver init:)
		(candy init:)
		(realWindow init:)
		(deadGuy1 init:)
		(crazyGuy init:)
		(closeBox init:)
		(refreshments init:)
		(magazines init:)
		(minimize init:)
		(maximize init:)
		(fileWord init:)
		(optionsWord init:)
		(sectorsWord init:)
		(helpWord init:)
		(exit560 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(if
			(and
				gTimers
				(not (gTimers contains: (ScriptID 0 11))) ; nowServingTimer
				(not (IsFlag 182))
			)
			((ScriptID 0 11) setReal: (ScriptID 0 11) 20) ; nowServingTimer, nowServingTimer
		)
		(Load 140 573) ; WAVE
		(countSnd init: setVol: 127)
		(if (not (IsFlag 182))
			(localproc_0)
		)
		(gGSound1 number: 570 setLoop: -1 play: setVol: 127)
	)

	(method (notify)
		(if (not (IsFlag 182))
			(localproc_0)
			(sisInny setScript: callNumber)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (>= (++ local4) 7)
				(= local4 0)
				(self setScript: nipplesHard)
			else
				(gMessager say: noun theVerb 0 0) ; "You saw it here first -- a preview of the famed information superhighway!"
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(gGSound1 fade: 0 10 10 1)
		(gGSound2 stop:)
		(countSnd stop:)
		(gEgo setScale: 0)
		(super dispose:)
	)
)

(instance egoEnters570 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setMotion: MoveTo 35 138 self)
			)
			(1
				(gGSound2 number: 572 loop: 0 play: setVol: 127)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoEntersFrom580 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(fileWindow cel: 1)
				(= ticks 45)
			)
			(2
				(fileWindow hide: dispose:)
				(gEgo view: 575 loop: 1 posn: 204 139)
				(gEgo
					cel: (gEgo lastCel:)
					show:
					setSpeed: 6
					setCycle: Beg self
				)
				(gGSound2 number: 579 loop: 0 play: setVol: 127)
			)
			(3
				(fileCabinet init: approachVerbs: 4) ; Do
				(= cycles 2)
			)
			(4
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance animateMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: Fwd)
				(if register
					(= ticks register)
				else
					(= ticks 180)
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client hide:)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance animateMeWithSnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and register (register soundNum:))
					(gGSound2
						number: (register soundNum:)
						loop: -1
						play:
						setVol: 127
					)
				)
				(client cel: 0 show: setCycle: Fwd)
				(if (and register (register howLong:))
					(= ticks (register howLong:))
				else
					(= ticks 180)
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(if (and register (register soundNum:))
					(gGSound2 stop:)
				)
				(client hide:)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (and register (register soundNum:))
			(gGSound2 stop:)
		)
		(super dispose: &rest)
	)
)

(instance playDitty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local2)
					(= local2 1)
					(gGSound1 stop:)
				)
				(client cel: 0 show: setCycle: Fwd)
				(gGSound2 number: 435 setLoop: 0 play: self setVol: 127)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client hide:)
				(= cycles 2)
			)
			(3
				(gGSound1 play:)
				(= local2 0)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if local2
			(gGSound1 play:)
			(= local2 0)
		)
		(super dispose: &rest)
	)
)

(instance getOlNumber3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 572
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(1
				(number3 hide:)
				(client setCycle: End self)
			)
			(2
				(client get: 75 normalize: 6) ; Number_3_Cord
				(gGame points: 1 501)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance printerActive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 3 cel: 0)
				(= ticks 45)
			)
			(1
				(client loop: 2 cel: 0)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance printerPrints of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 577) ; WAVE
				(gEgo
					view: 577
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 6)
				(client loop: 3 cel: 0 setCycle: Fwd)
				(if (not local3)
					(= local3 1)
					(gMessager say: 25 4 0 0 self) ; "The cyberprinter accepts your cyberfile gratefully, and begins to print. The question is, what exactly is the output of a cyberprinter?"
				else
					(gGSound2 number: 577 loop: -1 play: setVol: 127)
					(= ticks 1)
				)
			)
			(2
				(SetFlag register)
				(if
					(and
						(IsFlag 163)
						(IsFlag 164)
						(IsFlag 165)
						(IsFlag 166)
						(IsFlag 167)
					)
					(gMessager say: 25 4 10 0 self) ; "Well, what do you know! Maybe there is something to this superhero reputation thing after all."
					(gGame points: 3 489)
				else
					(= ticks 1)
				)
			)
			(3
				(if (not (gGSound2 handle:))
					(gGSound2 number: 577 loop: -1 play: setVol: 127)
				)
				(= ticks 240)
			)
			(4
				(gGSound2 stop:)
				(client setCycle: 0 loop: 2 cel: 0)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance workin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(= ticks (RandomNumber 300 600))
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(client loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(client loop: 0 cel: 0)
				(= ticks 30)
			)
			(4
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance callNumber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (client loop:) 4)
					(client setCycle: End self)
				else
					(client setCycle: Beg self)
				)
			)
			(1
				(client loop: (RandomNumber 1 3) cel: 0 setCycle: End self)
				(Sis_Inny showTalk: 0)
				(gMessager say: 12 2 11 0 self) ; "Next!"
			)
			(2 0)
			(3
				(client loop: 0 cel: 0)
				(Sis_Inny showTalk: 1)
				(= ticks 45)
			)
			(4
				(= next workin)
				(self dispose:)
			)
		)
	)
)

(instance giveOlNumber3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 3 2 4 1 2 self) ; "As a matter of fact, I do possess that number. Read it and weep, Pixel Woman."
			)
			(1
				(gEgo setMotion: MoveTo 156 (gEgo y:) self)
			)
			(2
				(client view: 576 loop: 0 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(3
				(client normalize: 7 setSpeed: 6)
				(= cycles 2)
			)
			(4
				(SetFlag 57)
				(gEgo put: 75) ; Number_3_Cord
				(gMessager sayRange: 3 2 4 3 4 self) ; "Oh. (SLIGHT PAUSE THEN IRRITATED) Well, I guess you're right."
			)
			(5
				(gTheCursor hide:)
				(arrow init: posn: 320 125 setMotion: MoveTo 197 88 self)
			)
			(6
				(arrow view: 570 loop: 10 cel: 0 setCycle: Fwd)
				(= cycles 45)
			)
			(7
				(= next climbIntoFileRoom)
				(self dispose:)
			)
		)
	)
)

(instance climbIntoFileRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(fileWindow posn: (- (gEgo x:) 41) (- (gEgo y:) 4) init:)
				(arrow
					view: 573
					loop: 5
					cel: 0
					setCycle: 0
					setMotion: MoveTo 265 (arrow y:) self
				)
			)
			(1
				(gEgo view: 575 loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(2
				(fileWindow hide:)
				(= cycles 2)
			)
			(3
				(arrow
					setPri: 200
					setMotion:
						MoveTo
						(+ (fileWindow x:) 61)
						(- (fileWindow y:) 64)
						self
				)
			)
			(4
				(Load 140 579) ; WAVE
				(arrow view: 570 loop: 10 cel: 0 setCycle: Fwd)
				(= cycles 30)
			)
			(5
				(gEgo setCycle: CT 15 1 self)
			)
			(6
				(gGSound2 number: 579 loop: 0 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(7
				(gEgo hide:)
				(fileWindow loop: 2 cel: 1 posn: 18 128 show:)
				(gGame points: 3 502)
				(= cycles 60)
			)
			(8
				(gTheCursor show:)
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance ringBell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 571) ; WAVE
				(ringer setScript: (animateMe new:) 0 30)
				(gGSound2 number: 571 setLoop: 0 play: setVol: 127)
				(= ticks 75)
			)
			(1
				(gMessager say: 3 2 2 0 self) ; "Does your number match the one shown by the counter?"
			)
			(2
				(cond
					((not (gEgo has: 75)) ; Number_3_Cord
						(gMessager say: 3 2 3 0 self) ; "No, uh, I don't seem to have that one, but ..."
					)
					((== gNowServingNumber 3)
						(= next giveOlNumber3)
						(= ticks 1)
					)
					(else
						(gMessager say: 3 2 3 0 self) ; "No, uh, I don't seem to have that one, but ..."
					)
				)
			)
			(3
				(gGame points: 3 496)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openCounter of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(gGame handsOff:)
				)
				((ScriptID 0 11) client: 0 delete: dispose:) ; nowServingTimer
				(= ticks 1)
			)
			(1
				(gEgo
					view: 574
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(2
				(onesCtr hide:)
				(tensCtr hide:)
				(tinyTensCtr cel: (tensCtr cel:))
				(if (gCast contains: tinyTensCtr)
					(tinyTensCtr show:)
				else
					(tinyTensCtr init:)
				)
				(tinyOnesCtr cel: (onesCtr cel:))
				(if (gCast contains: tinyOnesCtr)
					(tinyOnesCtr show:)
				else
					(tinyOnesCtr init:)
				)
				(gEgo setCycle: End self)
			)
			(3
				(gizmo init:)
				(= cycles 2)
			)
			(4
				(SetFlag 182)
				(gEgo normalize: 3)
				(if (not register)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance closeCounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 574 loop: 0)
				(gEgo
					cel: (gEgo lastCel:)
					setSpeed: 6
					setCycle: CT 4 -1 self
				)
			)
			(1
				(if (gCast contains: onesCtr)
					(onesCtr show:)
				else
					(onesCtr init:)
				)
				(if (gCast contains: tensCtr)
					(tensCtr show:)
				else
					(tensCtr init:)
				)
				(tinyOnesCtr hide:)
				(tinyTensCtr hide:)
				(gizmo hide:)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(ClearFlag 182)
				(gEgo normalize: 3)
				(localproc_0)
				((ScriptID 0 11) setReal: (ScriptID 0 11) 60) ; nowServingTimer, nowServingTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fixCounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 182)
					(= ticks 1)
				else
					(self setScript: openCounter self 1)
				)
			)
			(1
				(client view: 574 loop: 1 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(2
				(gGSound2 number: 578 loop: -1 play: setVol: 127)
				(client loop: 2 cel: 0 setCycle: Fwd)
				(tinyOnesCtr setCycle: Fwd)
				(tinyTensCtr cycleSpeed: 12 setCycle: Fwd)
				(= cycles 250)
			)
			(3
				(if (!= (client cel:) (client lastCel:))
					(client setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(4
				(gGSound2 stop:)
				(tinyOnesCtr cel: 3 setCycle: 0)
				(tinyTensCtr cel: 3 setCycle: 0)
				(client loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(5
				(if (gCast contains: onesCtr)
					(onesCtr show:)
				else
					(onesCtr init:)
				)
				(if (gCast contains: tensCtr)
					(tensCtr show:)
				else
					(tensCtr init:)
				)
				(tinyOnesCtr hide:)
				(tinyTensCtr hide:)
				(gizmo hide:)
				(= cycles 2)
			)
			(6
				(client setCycle: End self)
			)
			(7
				(ClearFlag 182)
				(client normalize: 3)
				(= gNowServingNumber 3)
				(localproc_0)
				((ScriptID 0 11) setReal: (ScriptID 0 11) 60) ; nowServingTimer, nowServingTimer
				(gGame points: 5 488)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(fileWindow
					view: 575
					loop: 0
					cel: 0
					posn: (- (gEgo x:) 41) (- (gEgo y:) 4)
					init:
				)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 575
					loop: 1
					cel: 0
					setSpeed: 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(fileWindow hide:)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo hide:)
				(fileWindow loop: 2 cel: 1 posn: 18 128 show:)
				(= cycles 30)
			)
			(5
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance takeFiles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo sisInny self)
			)
			(1
				(gMessager say: 0 0 7 0 self) ; "EX-cuse me, Mr. Wilco. Those are reference files only and not available for loan. You may leave, but the folders will remain here."
			)
			(2
				(if (gEgo has: 6) ; Beleaux_Record
					(gEgo put: 6) ; Beleaux_Record
				)
				(if (gEgo has: 74) ; Nigel_Record
					(gEgo put: 74) ; Nigel_Record
				)
				(if (gEgo has: 87) ; Project_Record
					(gEgo put: 87) ; Project_Record
				)
				(if (gEgo has: 62) ; Icky_Record
					(gEgo put: 62) ; Icky_Record
				)
				(if (gEgo has: 94) ; Sape_Record
					(gEgo put: 94) ; Sape_Record
				)
				(= cycles 2)
			)
			(3
				(gEgo setMotion: PolyPath -10 (gEgo y:) self)
			)
			(4
				(if (not (gGSound2 handle:))
					(gGSound2 number: 5720 loop: 0 play: setVol: 127)
					(= ticks 60)
				else
					(= ticks 1)
				)
			)
			(5
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance nipplesHard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 1 0 1 self) ; "You saw it here first -- a preview of the famed information superhighway!"
			)
			(1
				(gMessager say: 1 1 0 4 self) ; "Wow! This makes my nipples hard."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance leaveSimply of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath -10 (gEgo y:) self)
			)
			(1
				(if (not (gGSound2 handle:))
					(gGSound2 number: 5720 loop: 0 play: setVol: 127)
					(= ticks 60)
				else
					(= ticks 1)
				)
			)
			(2
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance arrow of Actor
	(properties
		x 150
		y 119
		view 573
		loop 5
		yStep 4
		xStep 6
		moveSpeed 2
	)

	(method (init)
		(|= signal $0800)
		(super init: &rest)
	)
)

(instance printer of Prop
	(properties
		noun 25
		sightAngle 40
		approachX 167
		approachY 138
		x 197
		y 125
		view 570
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(126 ; Beleaux_Record
				(gEgo put: 6) ; Beleaux_Record
				(self setScript: printerPrints 0 163)
			)
			(124 ; Nigel_Record
				(gEgo put: 74) ; Nigel_Record
				(self setScript: printerPrints 0 164)
			)
			(125 ; Project_Record
				(gEgo put: 87) ; Project_Record
				(self setScript: printerPrints 0 165)
			)
			(127 ; Icky_Record
				(gEgo put: 62) ; Icky_Record
				(self setScript: printerPrints 0 166)
			)
			(123 ; Sape_Record
				(gEgo put: 94) ; Sape_Record
				(self setScript: printerPrints 0 167)
			)
			(4 ; Do
				(self setScript: printerActive)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sisInny of Prop
	(properties
		noun 12
		sightAngle 40
		approachX 166
		approachY 138
		x 130
		y 100
		view 573
	)

	(method (doVerb theVerb)
		(switch theVerb
			(133 ; Number_3_Cord
				(if (not (IsFlag 57))
					(gEgo setScript: ringBell)
				else
					(gMessager say: 3 2 6 0) ; "Yo, Bit Boy. Do you like standing in line? You already have file room access. Move it!"
				)
			)
			(2 ; Talk
				(if (not (IsFlag 57))
					(gEgo setScript: ringBell)
				else
					(gMessager say: 3 2 6 0) ; "Yo, Bit Boy. Do you like standing in line? You already have file room access. Move it!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ringer of Prop
	(properties
		noun 3
		sightAngle 40
		x 150
		y 119
		view 570
		loop 4
	)
)

(class Counter of Prop
	(properties
		approachX 263
		approachY 139
	)

	(method (init)
		(self approachVerbs: 4 132) ; Do, Screwdriver
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (== gNowServingNumber 3) (gEgo has: 75)) ; Number_3_Cord
						(gMessager say: noun theVerb 12 0)
					)
					((== gNowServingNumber 3)
						(gMessager say: noun theVerb 13 (RandomNumber 1 3))
					)
					((IsFlag 182)
						(gEgo setScript: closeCounter)
					)
					(else
						(gEgo setScript: openCounter)
					)
				)
			)
			(132 ; Screwdriver
				(cond
					((and (== gNowServingNumber 3) (gEgo has: 75)) ; Number_3_Cord
						(gMessager say: noun 4 12 0)
					)
					((== gNowServingNumber 3)
						(gMessager say: noun 4 13 (RandomNumber 1 3))
					)
					(else
						(gEgo setScript: fixCounter)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tensCtr of Counter
	(properties
		noun 26
		sightAngle 40
		x 268
		y 65
		view 570
	)
)

(instance onesCtr of Counter
	(properties
		noun 26
		sightAngle 40
		x 276
		y 65
		view 570
		cel 4
	)
)

(instance tinyTensCtr of Counter
	(properties
		noun 26
		sightAngle 40
		x 271
		y 66
		view 574
		loop 4
	)
)

(instance tinyOnesCtr of Counter
	(properties
		noun 26
		sightAngle 40
		x 276
		y 66
		view 574
		loop 4
		cel 4
	)
)

(instance number3 of View
	(properties
		noun 27
		sightAngle 40
		approachX 227
		approachY 139
		x 246
		y 64
		view 570
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: getOlNumber3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fileWindow of View
	(properties
		noun 11
		sightAngle 40
		x 170
		y 34
		view 575
	)
)

(instance gizmo of View
	(properties
		noun 26
		sightAngle 40
		approachX 263
		approachY 139
		x 267
		y 56
		view 574
		loop 5
	)

	(method (init)
		(self approachVerbs: 4 132) ; Do, Screwdriver
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (== gNowServingNumber 3) (gEgo has: 75)) ; Number_3_Cord
						(gMessager say: noun theVerb 12 0) ; "I already have the right number."
					)
					((== gNowServingNumber 3)
						(gMessager say: noun theVerb 13 (RandomNumber 1 3))
					)
					((IsFlag 182)
						(gEgo setScript: closeCounter)
					)
					(else
						(gEgo setScript: openCounter)
					)
				)
			)
			(132 ; Screwdriver
				(if (not (IsFlag 57))
					(gEgo setScript: fixCounter)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bell of Feature
	(properties
		noun 3
		nsLeft 140
		nsTop 103
		nsRight 160
		nsBottom 118
		sightAngle 40
		approachX 166
		approachY 138
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 57))
					(gEgo setScript: ringBell)
				else
					(gMessager say: noun 2 6 0) ; "Yo, Bit Boy. Do you like standing in line? You already have file room access. Move it!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screenSaver of Feature
	(properties
		noun 8
		nsLeft 191
		nsTop 36
		nsRight 213
		nsBottom 58
		sightAngle 40
	)
)

(instance candy of Feature
	(properties
		noun 13
		nsLeft 100
		nsTop 106
		nsRight 123
		nsBottom 123
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(gMessager say: 13 4 1 1) ; "Your virtual breath can get no mintier."
				else
					(gMessager say: 13 4 0 1) ; "You virtually eat the nearly real mint. Your virtual breath is now virtually minty fresh."
					(= local0 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance realWindow of Feature
	(properties
		noun 15
		nsLeft 11
		nsTop 32
		nsRight 90
		nsBottom 78
		sightAngle 40
	)
)

(instance deadGuy1 of Feature
	(properties
		noun 4
		sightAngle 40
		x 77
		y 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 49 100 53 98 61 102 88 102 89 113 92 118 91 122 98 129 107 136 107 138 54 138 55 135 54 117 48 114 47 106
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance crazyGuy of Feature
	(properties
		noun 6
		sightAngle 40
		x 296
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 286 99 289 98 292 99 297 100 302 95 309 96 311 101 308 106 310 113 313 123 312 132 302 133 309 138 274 138 281 134 279 124 274 113 283 107
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance closeBox of Feature
	(properties
		noun 16
		nsLeft 3
		nsTop 3
		nsRight 12
		nsBottom 10
		sightAngle 40
	)
)

(instance refreshments of Feature
	(properties
		noun 19
		nsLeft 240
		nsTop 21
		nsRight 255
		nsBottom 32
		sightAngle 40
	)
)

(instance magazines of Feature
	(properties
		noun 20
		nsLeft 275
		nsTop 21
		nsRight 290
		nsBottom 32
		sightAngle 40
	)
)

(instance maximize of Feature
	(properties
		noun 18
		nsLeft 299
		nsTop 2
		nsRight 307
		nsBottom 9
		sightAngle 40
	)
)

(instance minimize of Feature
	(properties
		noun 17
		nsLeft 308
		nsTop 2
		nsRight 316
		nsBottom 9
		sightAngle 40
	)
)

(instance fileWord of Feature
	(properties
		noun 24
		nsLeft 6
		nsTop 9
		nsRight 19
		nsBottom 16
		sightAngle 40
	)
)

(instance optionsWord of Feature
	(properties
		noun 22
		nsLeft 20
		nsTop 9
		nsRight 47
		nsBottom 16
		sightAngle 40
	)
)

(instance sectorsWord of Feature
	(properties
		noun 23
		nsLeft 48
		nsTop 9
		nsRight 76
		nsBottom 16
		sightAngle 40
	)
)

(instance helpWord of Feature
	(properties
		noun 21
		nsLeft 77
		nsTop 9
		nsRight 95
		nsBottom 16
		sightAngle 40
	)
)

(instance fileCabinet of Feature
	(properties
		noun 11
		nsLeft 188
		nsTop 80
		nsRight 207
		nsBottom 102
		sightAngle 40
		approachX 202
		approachY 138
		x 198
		y 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 57)
					(gEgo setScript: leaveRoom)
				else
					(gMessager say: noun theVerb 9 0) ; "(SASSY) Just what do you think you're doing, Sir!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exit560 of ExitFeature
	(properties
		nsTop 80
		nsRight 7
		nsBottom 138
		nextRoom 560
		message 8
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(self isNotHidden:)
				(or
					(gEgo has: 6) ; Beleaux_Record
					(gEgo has: 74) ; Nigel_Record
					(gEgo has: 87) ; Project_Record
					(gEgo has: 62) ; Icky_Record
					(gEgo has: 94) ; Sape_Record
				)
			)
			(= approachX 20)
			(= approachY (gEgo y:))
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb message)
				(super doVerb: theVerb &rest)
			)
			(
				(or
					(gEgo has: 6) ; Beleaux_Record
					(gEgo has: 74) ; Nigel_Record
					(gEgo has: 87) ; Project_Record
					(gEgo has: 62) ; Icky_Record
					(gEgo has: 94) ; Sape_Record
				)
				(sisInny setScript: takeFiles)
			)
			(else
				(gEgo setScript: leaveSimply)
			)
		)
	)
)

(class SillyIcons of Feature
	(properties
		myProp 0
		howLong 210
		soundNum 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if soundNum
					(myProp setScript: (animateMeWithSnd new:) 0 self)
				else
					(myProp setScript: (animateMe new:) 0 howLong)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trash of SillyIcons
	(properties
		noun 9
		nsLeft 101
		nsTop 36
		nsRight 116
		nsBottom 58
		sightAngle 40
		howLong 60
		soundNum 576
	)

	(method (init)
		(= myProp siTrash)
		(super init: &rest)
	)
)

(instance radio of SillyIcons
	(properties
		noun 10
		nsLeft 119
		nsTop 36
		nsRight 142
		nsBottom 58
		sightAngle 40
	)

	(method (init)
		(= myProp siRadio)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(cond
			((and (& (event type:) evMOUSEBUTTON) local1 (not (self onMe: event)))
				(= local1 0)
				(gGSound2 stop:)
				(myProp setCycle: 0 setScript: 0 hide:)
				(super handleEvent: event &rest)
			)
			((and (& (event type:) evMOUSEBUTTON) local1 (self onMe: event))
				(= local1 0)
				(gGSound2 stop:)
				(myProp setCycle: 0 setScript: 0 hide:)
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(if (and (not local1) (== theVerb 4)) ; Do
			(= local1 1)
			(myProp setScript: playDitty)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
	)
)

(instance clock of SillyIcons
	(properties
		noun 2
		nsLeft 146
		nsTop 36
		nsRight 164
		nsBottom 58
		sightAngle 40
		howLong 80
		soundNum 575
	)

	(method (init)
		(= myProp siClock)
		(super init: &rest)
	)
)

(instance fan of SillyIcons
	(properties
		noun 7
		nsLeft 167
		nsTop 36
		nsRight 186
		nsBottom 58
		sightAngle 40
		soundNum 574
	)

	(method (init)
		(= myProp siFan)
		(super init: &rest)
	)
)

(instance siFan of Prop
	(properties
		noun 7
		sightAngle 40
		x 176
		y 58
		view 570
		loop 5
		cycleSpeed 2
	)
)

(instance siClock of Prop
	(properties
		noun 2
		sightAngle 40
		x 155
		y 57
		view 570
		loop 6
	)
)

(instance siRadio of Prop
	(properties
		noun 10
		sightAngle 40
		x 131
		y 57
		view 570
		loop 8
	)
)

(instance siTrash of Prop
	(properties
		noun 9
		sightAngle 40
		x 108
		y 58
		view 570
		loop 7
	)
)

(instance Sis_Inny of SmallTalker
	(properties
		name {Sis Inny}
		talkView 573
		talkLoop 1
	)

	(method (init)
		(= client sisInny)
		(cond
			((< (Abs (- (gEgo x:) (client x:))) 20)
				(= talkLoop 1)
			)
			((> (gEgo x:) (client x:))
				(= talkLoop 3)
			)
			(else
				(= talkLoop 2)
			)
		)
		(super init: &rest)
	)
)

(instance countSnd of Sound
	(properties
		number 573
		loop 0
	)
)

