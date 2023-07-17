;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use Array)
(use Print)
(use Inset)
(use Polygon)
(use Feature)
(use LoadMany)
(use DCIcon)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0
	local1
	local2
	local3
	[local4 13]
	[local17 11] = [{KGirl} {DGirl} {HGirl} {CGirl} {IGirl} {BGirl} {EGirl} {AGirl} {FGirl} {GGirl} {JGirl}]
	[local28 11] = [242 239 160 199 200 222 217 156 114 143 218]
	[local39 11] = [83 61 97 56 86 45 71 47 80 81 100]
	[local50 11] = [229 229 153 192 192 210 206 144 104 133 209]
	[local61 11] = [80 58 90 55 82 44 67 46 78 79 98]
	local72
	local73
	local74
	local75
	local76
	local77 = 5
	local78
	local79
	local80
	local81
	local82
	local83
	local84
	local85
	local86
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (not [local4 0])
		(return)
	)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		([local4 temp0] cel: param1)
		(if (> argc 1)
			([local4 temp0] view: param2)
		)
	)
	(if (and local74 (!= local74 ([local4 0] view:)))
		(UnLoad 128 local74)
		(= local74 ([local4 0] view:))
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= local76 1)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		((= [local4 temp0] (Girl new:))
			name: [local17 temp0]
			view: 445
			setLoop: temp0
			cel: 0
			x: [local50 temp0]
			y: [local61 temp0]
			ignoreActors: 1
			priority: 108
			fixPriority: 1
			signal: 26657
			init:
			setCycle: 0
			approachX: [local28 temp0]
			approachY: [local39 temp0]
			noun: 14
			approachVerbs: 4 1 2 5 6 ; Do, Look, Talk, Take, Zipper
		)
	)
	(if argc
		(param1 cue:)
	)
)

(procedure (localproc_2 param1 param2 param3)
	(gGame handsOff:)
	(if (> argc 2)
		(gMessager say: param1 param2 param3 0 retCtrlCue 460)
	else
		(gMessager say: param1 param2 0 0 retCtrlCue 460)
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
	(gGlobalSound1 number: 313 play: setLoop: 1)
	(Load rsVIEW 453)
	(= temp1 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(= temp4 80)
	(= temp6 90)
	(= temp5 180)
	(= temp7 90)
	(= temp8 10)
	(= temp10 57)
	(= temp3 0)
	(SetCursor 255 100)
	(while (not temp3)
		(Print
			font: gUserFont
			width: 110
			back: 46
			addTitle: 2 0 1 2 82
			addText: 2 0 1 1 72 1 82 ; "As the last breath of life slowly ebbs from your body, you think to yourself, "So what? Those are tits to die for!""
			addIcon: frameIcon -1 -1 2 4
			addIcon: (deathIcon view: 453 cel: 0 loop: 0 yourself:) -1 -1 0 1
		)
		((Print dialog:) setSize:)
		(= temp3
			(Print
				addButton: 1 2 0 3 1 73 57 82 ; "Restore"
				addButton: 0 2 0 2 1 140 57 82 ; "Try Again"
				init:
			)
		)
		(DoAudio audSTOP 82 2 0 1 1) ; "As the last breath of life slowly ebbs from your body, you think to yourself, "So what? Those are tits to die for!""
		(switch temp3
			(0
				(Print back: 7)
				(gGame setCursor: temp1)
				(sfx number: 0 dispose:)
				(gGlobalSound1 number: 0 stop:)
				(gSounds eachElementDo: #pause 0)
				(if param2
					(param2 cue:)
				)
				(= temp3 -1)
			)
			(1
				(= local3 0)
				(gGame restore:)
				(FrameOut)
				(= temp3 0)
			)
		)
	)
	(LoadMany 0 64967)
)

(instance rm440 of LarryRoom
	(properties
		noun 1
		picture 440
		horizon 0
		autoLoad 0
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 109 51 120 51 120 63 109 63
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 96 72 107 72 107 85 96 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 125 74 137 74 137 88 125 88
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 145 83 158 83 158 97 145 97
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 185 50 197 50 197 63 185 63
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 220 54 232 54 232 67 220 67
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 198 64 210 64 210 77 198 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 183 75 195 75 195 90 183 90
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 221 74 234 74 234 88 221 88
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 199 105 199 94 214 94 214 106 254 106 254 92 239 81 239 63 244 54 260 46 258 39 216 43 216 53 202 53 202 44 149 44 149 54 136 54 136 45 74 45 74 105
					yourself:
				)
		)
		(recordPlayer init: approachVerbs: 4 1 2 5 6 ignoreActors: 1) ; Do, Look, Talk, Take, Zipper
		(rightDoor init: approachVerbs: 4 ignoreActors: 1) ; Do
		(leftDoor init: approachVerbs: 4 ignoreActors: 1) ; Do
		(switch gPrevRoomNum
			(455
				(gEgo init: normalize: 441 0 posn: 241 69 setPri: 107)
			)
			(230
				(gEgo init: normalize: 441 1 x: 283 y: 98 setPri: 107)
				(rightDoor cel: (rightDoor lastCel:))
				(gCurRoom setScript: enterThruDoorScr 0 2)
			)
			(460
				(gEgo init: normalize: 441 0 x: 239 y: 69 setPri: 107)
				(cav
					init:
					approachVerbs: 4 1 2 5 6 ; Do, Look, Talk, Take, Zipper
					setLoop: 5 1
					ignoreActors: 1
				)
				(self setScript: talkToCavScr 0 1)
			)
			(else
				(gEgo init: normalize: 441 3 x: 120 y: 119 setPri: 107)
				(leftDoor cel: (leftDoor lastCel:))
				(gCurRoom setScript: enterThruDoorScr 0 1)
			)
		)
		(UnLoad 128 900)
		(gGlobalSound2 number: 0 stop:)
		(cond
			((or (IsFlag 210) (IsFlag 66)))
			((and (IsFlag 9) (not (OneOf gPrevRoomNum 460 455)))
				(gGlobalSound2 number: 440 loop: -1 play: setVol: 127)
				(localproc_1)
				(recordPlayer setCycle: Fwd)
				(upperSpeaker init: approachVerbs: 4 5 ignoreActors: 1) ; Do, Take
				(lowerSpeaker init: approachVerbs: 4 5 ignoreActors: 1) ; Do, Take
				(cav init: approachVerbs: 4 1 2 5 6 setScript: cavScr) ; Do, Look, Talk, Take, Zipper
			)
			(else
				(cav init: view: 442 setLoop: 0 cel: 0 approachVerbs: 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
			)
		)
		(larryStep init: approachVerbs: 4) ; Do
		(stage init: approachVerbs: 4) ; Do
		(waterPipes init:)
		(rightLight init:)
		(upperLight init:)
		(upperLight2 init:)
		(lowerLight init:)
		(lowerLight2 init:)
		(Load rsMESSAGE 440)
		(Load rsSCRIPT 1802)
		(= local82 1)
		(cond
			((ResCheck 140 346) ; WAVE
				(= local84 140)
			)
			((ResCheck rsAUDIO 346)
				(= local84 141)
			)
			(else
				(= local84 132)
			)
		)
		(proc79_11 814 355 346 347 445 443 444)
	)

	(method (doit)
		(if (and (not local76) (== (gEgo view:) 441))
			(switch (gEgo cel:)
				(0
					(if (== local82 2)
						(= local82 1)
						(sfx number: 346 loop: 1 play:)
					)
				)
				(3
					(if (== local82 1)
						(= local82 2)
						(sfx number: 347 loop: 1 play:)
					)
				)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(titTimer dispose: delete:)
		(punchTimer dispose: delete:)
		(super newRoom: newRoomNumber)
		(if (not (OneOf newRoomNumber 420 230))
			(gEgo normalize: 900)
		)
	)

	(method (dispose)
		(sfx number: 0 dispose:)
		(proc79_12 814 355 346 347 445 443 444)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local76
						(gMessager say: 1 1 1) ; "What a wonderful place you've stumbled upon, Larry! A room filled with hot sweaty women dressed in skimpy tight-fitting outfits!!"
						(return 1)
					)
					(local75
						(gMessager say: 1 1 3) ; "The aerobics room is empty now, except for that beautiful aerobics instructor standing on the small stage near the east end of the room."
						(return 1)
					)
					(else
						(return (super doVerb: theVerb))
					)
				)
			)
			(6 ; Zipper
				(if local76
					(gMessager say: 1 6) ; "This is not a good place to expose yourself. These gals look tough!"
				else
					(gMessager say: 1 6 4) ; "Now? The girls are gone!"
				)
				(return 1)
			)
			(2 ; Talk
				(cond
					(local76
						(gMessager say: 1 2 1) ; "Hey, girls! New man on campus!"
						(return 1)
					)
					((gCast contains: cav)
						(gMessager say: 1 2 3) ; "Excuse me, Miss? May I speak to you?"
						(return 1)
					)
					(else
						(return (super doVerb: theVerb))
					)
				)
			)
			(else
				(return (super doVerb: theVerb))
			)
		)
	)

	(method (cue)
		(closeUpInset dispose:)
	)
)

(class cObj of Obj
	(properties)
)

(instance enterThruDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 20)
			)
			(1
				(if (== register 2)
					(= state 9)
					(= cycles 2)
				else
					(gEgo setMotion: MoveTo 124 97 self)
				)
			)
			(2
				(leftDoor setCycle: Beg self)
			)
			(3
				(sfx number: 33 loop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
			(10
				(gEgo setMotion: MoveTo 250 98 self)
			)
			(11
				(rightDoor setCycle: Beg self)
			)
			(12
				(sfx number: 33 loop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cav of Actor
	(properties
		noun 2
		approachX 239
		approachY 69
		x 260
		y 66
		view 442
		loop 5
		signal 26657
	)

	(method (cue)
		(super cue:)
		(if (IsFlag 6)
			(cav view: 442 setLoop: 0 cel: 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if [local4 0]
					(gMessager say: 2 2 1 0) ; "Perhaps I shouldn't bother her; she's quite focused on her work."
				else
					(gCurRoom setScript: talkToCavScr)
				)
			)
			(1 ; Look
				(if [local4 0]
					(gMessager say: 2 2 1 0) ; "Perhaps I shouldn't bother her; she's quite focused on her work."
				else
					(gCurRoom setScript: talkToCavScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(= local75 1)
		(super init:)
	)
)

(instance larryStep of Feature
	(properties
		noun 15
		approachX 107
		approachY 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 48 122 48 122 66 107 66
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 209)
						(gMessager say: 15 1) ; "That's the aerobics step where you proved you have no rhythm."
					)
					(local76
						(gMessager say: 15 1 1) ; "There is one empty aerobic step just waiting for another overweight body."
					)
				)
			)
			(4 ; Do
				(if local76
					(gCurRoom setScript: larryScr 0 0)
				else
					(gCurRoom setScript: larryScr 0 -2)
				)
			)
			(5 ; Take
				(if local76
					(gMessager say: 15 5 1) ; "This could be a big step in your life... if you'd only try!"
				else
					(gMessager say: 15 5) ; "This could be a big step in your life... but it wasn't!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		noun 16
		approachX 255
		approachY 97
		x 265
		y 95
		priority 170
		fixPriority 1
		view 440
		loop 1
		signal 26657
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 258 89 282 90 279 109 258 107
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: exitThruDoorScr 0 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftDoor of Prop
	(properties
		noun 4
		approachX 121
		approachY 105
		x 127
		y 107
		priority 170
		fixPriority 1
		view 440
		signal 26657
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: exitThruDoorScr 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stage of Feature
	(properties
		noun 17
		approachX 239
		approachY 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 87 252 83 243 75 242 64 248 55 260 49 269 49
					yourself:
				)
		)
		(super init:)
	)
)

(instance waterPipes of Feature
	(properties
		noun 18
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 65 18 62 21 65 166 65 166 0 173 0 173 63 175 66 177 64 177 61 183 62 186 66 183 71 178 72 172 71 172 138 166 138 166 70 162 70 29 70 17 72 0 72
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightLight of Feature
	(properties
		noun 19
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 52 291 62 301 65 309 60 315 62 313 75 306 76 300 71 291 72 276 83
					yourself:
				)
		)
		(super init:)
	)
)

(instance exitThruDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 2)
					(= state 3)
					(= cycles 2)
				else
					(sfx number: 32 loop: 1 play:)
					(leftDoor setCycle: End self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 121 119 self)
				(gGlobalSound2 fade: 0 10 10 1)
			)
			(2
				(if global205
					(proc79_7)
				)
				(= ticks 120)
			)
			(3
				(gGlobalSound2 number: 0 stop:)
				(gCurRoom newRoom: 420)
			)
			(4
				(sfx number: 32 loop: 1 play:)
				(rightDoor setCycle: End self)
			)
			(5
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(gGlobalSound2 fade: 0 10 10 1)
			)
			(6
				(gEgo hide:)
				(if global205
					(proc79_7)
				)
				(= ticks 120)
			)
			(7
				(gGlobalSound2 number: 0 stop:)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance Girl of Prop
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(= temp0 (Random 1 6))
				(gMessager say: 14 2 0 temp0)
			)
			(4 ; Do
				(= temp0 (Random 1 5))
				(gMessager say: 14 4 0 temp0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperSpeaker of Prop
	(properties
		noun 3
		sightAngle 10
		approachX 258
		approachY 41
		x 270
		y 41
		priority 41
		fixPriority 1
		view 440
		loop 2
		signal 26657
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 49 265 49 262 34 275 34
					yourself:
				)
		)
		(super init:)
	)

	(method (doit)
		(if (== (gGlobalSound2 prevSignal:) 10)
			(= cel 1)
			(gGlobalSound2 prevSignal: 0)
		else
			(= cel 0)
		)
		(super doit:)
	)
)

(instance lowerSpeaker of View
	(properties
		noun 3
		sightAngle 10
		approachX 254
		approachY 106
		x 258
		y 106
		priority 106
		fixPriority 1
		view 440
		loop 2
		signal 26657
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 112 253 114 250 99 261 97
					yourself:
				)
		)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(= cel (upperSpeaker cel:))
	)
)

(instance tits of View
	(properties
		x 116
		y 73
		priority 84
		fixPriority 1
		view 460
		loop 4
		signal 26657
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance titCue of cObj
	(properties)

	(method (cue)
		(= local80 0)
	)
)

(instance fastForwardCue of cObj
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(= global215 (ByteArray new: 40))
		(= global214 (ByteArray new: 40))
		(Message msgGET 440 0 0 23 1 (global215 data:)) ; "Get those girls out of here!"
		(Message msgGET 440 0 0 24 1 (global214 data:)) ; "You are so impatient!"
		(= global213 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 220 105)
		(if
			(Print
				width: 200
				font: gUserFont
				addTitle: (global214 data:)
				addText: (global215 data:) 50 1
				addIcon: 1911 0 0 0 0
				addButton: 0 0 0 27 1 50 33 440 ; "Oops"
				addButton: 1 0 0 28 1 120 33 440 ; "Yes"
				init:
			)
			(recordPlayer setCycle: 0 cel: 0)
			(larryScr register: 5)
			(= local73 2)
			(gGlobalSound2 number: 0 stop:)
		else
			(= global170 self)
			(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
		)
		(global215 dispose:)
		(= global215 0)
		(global214 dispose:)
		(= global214 0)
		(gGame setCursor: global213)
	)
)

(instance rightBoob of Feature
	(properties
		noun 4
		modNum 460
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 115 131 106 150 108 158 122 150 133 139 138 130 137 121 123
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(localproc_2 4 theVerb)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance leftBoob of Feature
	(properties
		noun 1
		modNum 460
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 120 198 128 189 137 175 137 168 131 168 115 173 107 188 108
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(localproc_2 1 theVerb)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance shirt of Feature
	(properties
		noun 6
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 76 136 71 142 88 155 95 159 96 163 92 171 92 179 80 179 68 188 70 188 104 199 117 198 132 188 131 189 133 184 133 180 128 179 130 173 129 169 131 162 127 156 128 149 131 141 131 138 135 132 131 131 132 128 131 126 135 120 128 121 115 128 105 130 90
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gEgo has: 0)) ; badge
						(localproc_2 6 4)
					)
					(local80
						((gCurRoom script:) setScript: takeOffShirtScr)
					)
					(else
						(= local80 1)
						(titTimer setReal: titCue 5)
						(localproc_2 6 4 6)
					)
				)
			)
			(1 ; Look
				(localproc_2 6 theVerb)
			)
			(5 ; Take
				(localproc_2 6 theVerb)
			)
			(else
				(closeUpInset doVerb: theVerb)
			)
		)
	)
)

(instance face of Feature
	(properties
		noun 8
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 64 138 43 140 18 147 15 168 15 175 33 173 53 163 64
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_2 8 theVerb)
			)
			(1 ; Look
				(if local79
					(localproc_2 8 theVerb 4)
				else
					(= local79 1)
					(localproc_2 8 theVerb)
				)
			)
			(else
				(closeUpInset doVerb: theVerb)
			)
		)
	)
)

(instance earring of Feature
	(properties
		noun 9
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 44 143 44 143 65 136 69
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 5) ; Do, Look, Take
			(localproc_2 9 theVerb)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance rightArm of Feature
	(properties
		noun 10
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 67 198 68 209 81 215 138 196 138 193 133 199 122 198 110 189 104 188 78 183 67
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(localproc_2 10 theVerb)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance leftArm of Feature
	(properties
		noun 10
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 138 114 138 113 84 116 75 130 72 129 101 121 113 121 126
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(localproc_2 10 theVerb)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance chest of Feature
	(properties
		noun 10
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 65 171 57 175 63 181 68 181 75 172 91 157 95 145 88 136 71 145 65 147 58
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(localproc_2 10 theVerb)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance titTimer of Timer
	(properties)

	(method (cue)
		(localproc_2 0 0 7)
	)
)

(instance punchTimer of Timer
	(properties)

	(method (cue)
		(closeUpInset dispose:)
	)
)

(instance upperLight of Feature
	(properties
		noun 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 88 293 88 293 85 302 82 307 82 319 89 318 104 299 110 292 106 292 104 173 104
					yourself:
				)
		)
		(super init:)
	)
)

(instance lowerLight of Feature
	(properties
		noun 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 174 32 296 32 296 29 307 26 319 34 319 45 302 55 295 51 295 49 174 49
					yourself:
				)
		)
		(super init:)
	)
)

(instance upperLight2 of Feature
	(properties
		noun 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 32 16 23 26 28 26 32 165 32 165 49 26 49 19 53 0 48
					yourself:
				)
		)
		(super init:)
	)
)

(instance lowerLight2 of Feature
	(properties
		noun 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 90 21 80 27 88 165 88 165 104 27 104 27 107 21 110 0 100
					yourself:
				)
		)
		(super init:)
	)
)

(instance talkToCavScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(cav view: 452 setMotion: MoveTo 250 68 self)
			)
			(2
				(cav view: 442 setLoop: 0 cel: 0)
				(Load rsMESSAGE 460)
				(Load rsPIC 460)
				(Load rsVIEW 460)
				(if (not (IsFlag 62))
					(gMessager say: 2 1 0 1 self 440) ; "Hello, Miss. My name is Larry; Larry Laffer!"
				else
					(gMessager say: 2 1 2 1 self 440) ; "Hi, Cav!"
				)
			)
			(3
				(ClearFlag 9)
				(gGlobalSound2 number: 442 loop: -1 play:)
				(if global205
					(proc79_7)
				)
				(= cycles 2)
			)
			(4
				(gCurRoom setInset: closeUpInset self)
			)
			(5
				(if (IsFlag 6)
					(gGame handsOff:)
					(gEgo view: 98)
					(cav view: 450 setLoop: 0 posn: 239 69 cel: 0)
					(UnLoad 128 442)
					(UnLoad 128 443)
					(UnLoad 128 449)
					(UnLoad 128 445)
					(UnLoad 128 446)
					(UnLoad 128 460)
					(UnLoad 129 460)
					(UnLoad 143 440)
					(UnLoad 143 460)
					(Load rsVIEW 1906)
					(Load rsVIEW 451)
					(Load rsVIEW 441)
					(gGlobalSound2 number: 0 stop:)
					(= ticks 120)
				else
					(self dispose:)
				)
			)
			(6
				(cav setCycle: CT 5 1 self)
			)
			(7
				(UpdateScreenItem ((ScriptID 92 3) view: 1906)) ; larryTBust
				(sfx number: 443 loop: 1 play:)
				(leftDoor setPri: 106)
				(ShakeScreen 1 ssUPDOWN)
				(= ticks 4)
			)
			(8
				(cav cel: 6)
				(gEgo
					view: 451
					setLoop: 0
					cel: 0
					x: 239
					y: 69
					scaleSignal: 1
					scaleX: 12
					scaleY: 12
					setCycle: 0
				)
				(= ticks 4)
			)
			(9
				(gEgo x: 229 y: 68 scaleX: 21 scaleY: 21)
				(= ticks 4)
			)
			(10
				(gEgo x: 204 y: 69 scaleX: 46 scaleY: 46)
				(= ticks 4)
			)
			(11
				(gEgo x: 163 y: 69 scaleX: 80 scaleY: 80)
				(cav
					view: 452
					setLoop: 0
					setMotion: MoveTo (+ (cav x:) 10) (cav y:) cav
				)
				(= ticks 4)
			)
			(12
				(gEgo x: 104 y: 68 setScale: 0)
				(= ticks 4)
			)
			(13
				(sfx number: 444 loop: 1 play:)
				(gEgo setLoop: 1 setMotion: 0)
				(ShakeScreen 2 ssUPDOWN)
				(= ticks 120)
			)
			(14
				(localproc_3 1 self)
			)
			(15
				(UpdateScreenItem ((ScriptID 92 3) view: 1900 loop: 1)) ; larryTBust
				(ClearFlag 6)
				(gEgo normalize: 441 0 posn: 239 69 setPri: 107)
				(leftDoor setPri: 170)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theBadge of View
	(properties
		noun 7
		modNum 460
		x 155
		y 130
		priority 130
		fixPriority 1
		view 460
		loop 5
		signal 26657
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 139 158 125 166 125 174 135 169 139
					yourself:
				)
		)
		(super init:)
		(badgePoly init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_2 7 theVerb)
			)
			(1 ; Look
				(if (not local83)
					(= local83 1)
					(localproc_2 7 1)
				else
					(localproc_2 7 1 5)
				)
			)
			(2 ; Talk
				(localproc_2 7 2)
			)
			(5 ; Take
				(switch (++ local81)
					(1
						(localproc_2 7 5 8)
					)
					(2
						(localproc_2 7 5 9)
					)
					(else
						((gCurRoom script:) setScript: takeBadgeScr)
					)
				)
			)
			(else
				(closeUpInset doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(badgePoly dispose:)
		(super dispose:)
	)
)

(instance takeOffShirtScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 4 1 1 self 460) ; "Oh, all right! You can have a quick peek!"
			)
			(1
				(tits show:)
				(theBadge x: 156 y: 123)
				(= ticks 120)
			)
			(2
				(sfx number: 312 loop: 1 play:)
				(= ticks 30)
			)
			(3
				(gMessager say: 6 4 1 2 self 460) ; "Oooohhhh!! WOW!"
			)
			(4
				(= ticks 30)
			)
			(5
				(gMessager say: 6 4 1 3 self 460) ; "Of course, you know now that you've seen them, you're gonna have to die!"
			)
			(6
				(= ticks 30)
			)
			(7
				(gMessager say: 6 4 1 4 self 460) ; "(CRY OF ANGUISH) Yeow!"
			)
			(8
				(SetFlag 6)
				(punchTimer setCycle: punchTimer 2)
				(self dispose:)
			)
		)
	)
)

(instance recordPlayer of Prop
	(properties
		noun 6
		approachX 249
		approachY 51
		x 259
		y 55
		priority 55
		fixPriority 1
		view 440
		loop 3
		signal 26657
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: cav)
					(gMessager say: 6 4 3) ; "Keep your hands off my stereo system, buster!"
				else
					(gCurRoom setScript: playARecordScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance larryScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 115 57 self)
			)
			(1
				(if (== register -2)
					(gMessager say: 15 4 0 0 self) ; "(CHILD-LIKE) Whee!"
				else
					(= state 3)
					(gMessager say: 15 4 1 1 self) ; "Maybe I'll join in. I haven't worked out in the last three games!"
				)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(larryStep approachX:)
						(larryStep approachY:)
						self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
			(4
				(= register 1)
				(= global170 fastForwardCue)
				(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
				(= cycles 2)
			)
			(5
				(if (OneOf (cav loop:) 4 5 6)
					(if (> gHowFast 3)
						(gEgo cycleSpeed: 6)
					else
						(gEgo cycleSpeed: 4)
					)
					(gEgo view: 443 setLoop: (- (cav loop:) 4) setCycle: Fwd)
				else
					(gEgo view: 441 setLoop: 8 cel: 0 setCycle: 0)
				)
				(cond
					((and (!= (cav loop:) 8) (not (-- local77)))
						(gMessager say: 15 4 1 (++ register) self)
						(= local77 (Random 4 6))
					)
					((== register 3)
						(= local77 (= cycles 1))
					)
					(else
						(= ticks 90)
					)
				)
				(if (< register 5)
					(-- state)
				)
			)
			(6
				(if (not local73)
					(= local73 1)
				)
				(if global170
					(= global170 0)
					(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				)
				(gEgo normalize: 441 setLoop: 0 setCycle: 0 setPri: 107)
			)
			(7
				(= global166 (ScriptID 0 3)) ; icon0
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeBadgeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager sayRange: 7 5 10 1 3 self 460) ; "Oh, no! Look! Your badge got caught on my finger. Okay, now I have to amputate my finger, or you can give me your badge! Either way, you pick. I don't care!"
			)
			(2
				(theBadge dispose:)
				(gGame changeScore: 15 210)
				(gEgo get: 0) ; badge
				(= seconds 4)
			)
			(3
				(gMessager sayRange: 7 5 10 4 7 self 460) ; "In fact, I have an idea: let's meet later today for a sauna together? Bring your best girl and meet me in the Swedish Sauna. We'll double-date!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance badgePoly of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 146 156 170 157 170 147 157 141 153 147 147 148
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(theBadge doVerb: theVerb)
	)
)

(instance playARecordScr of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 2])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local85)
					(= local85 1)
					(gMessager say: 6 0 0 0 self) ; "Peering through Cav's record collection, you find one album that particularly excites you: the soundtrack from "Leisure Suit Larry 6: Shape Up or Slip Out!""
				else
					(= cycles 2)
				)
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(= global214 (ByteArray new: 30))
				(Message msgGET 440 5 0 5 1 (global214 data:)) ; "Shape Up or Slip Out!"
				(Print
					width: 140
					font: 999
					addTitle: (global214 data:)
					x: -1
					y: 18
					addButton: 1000 5 0 6 1 0 0 440 ; "The Larry Theme"
					addButton: 230 5 0 7 1 115 0 440 ; "Air for the G-String"
					addButton: 380 5 0 9 1 0 15 440 ; "Shock Your Booty"
					addButton: 440 5 0 10 1 115 15 440 ; "2 Rump 2 Pump"
				)
				(global214 dispose:)
				(= global214 0)
				(if
					(= temp0
						(Print
							addButton: 442 5 0 11 1 0 30 440 ; "Switch Hitt'n Kitt'n"
							addButton: 511 5 0 12 1 115 30 440 ; "Harry Palm Blues"
							addButton: 1001 5 0 13 1 0 45 440 ; "Cell Block Love"
							addButton: 560 5 0 14 1 115 45 440 ; "Un Noche en Parlier"
							addButton: 860 5 0 15 1 0 60 440 ; "Samba de Hooters"
							addButton: 320 5 0 16 1 115 60 440 ; "Spanish Surprise"
							addButton: 420 5 0 18 1 0 75 440 ; "Larry Be Bad!"
							addButton: 580 5 0 20 1 115 75 440 ; "Muskrat Lust"
							addButton: 430 5 0 19 1 0 90 440 ; "No Pain, No Gain"
							addButton: 840 5 0 21 1 115 90 440 ; "Twist Till It Hurts"
							addButton: 310 5 0 8 1 0 105 440 ; "Hard is Good, Right?"
							addButton: 337 5 0 22 1 115 105 440 ; "Not Ravel's Bolero"
							init:
						)
					)
					(gGlobalSound2 number: temp0 loop: -1 play:)
					(recordPlayer setCycle: Fwd)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance retCtrlCue of cObj
	(properties)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance closeUpInset of Inset
	(properties
		picture 460
		noun 2
	)

	(method (init)
		(gCurRoom curPic: 460)
		(self picture: 460 plane: 0)
		(super init: &rest)
		(gGraphMenuBar state: (| (gGraphMenuBar state:) $0004))
		(if (not (IsFlag 62))
			(SetFlag 62)
			(titTimer setCycle: titTimer 4)
		else
			(gGame handsOn:)
		)
		((ScriptID 0 11) init: gCurRoom) ; iconExit
		(gTheIconBar disableIcon: (ScriptID 0 11) show:) ; iconExit
		(rightArm init:)
		(leftArm init:)
		(chest init:)
		(face init:)
		(if (not (IsFlag 210))
			(theBadge init: y: 130 ignoreActors: 1)
		)
		(shirt init:)
		(rightBoob init:)
		(leftBoob init:)
		(tits init: hide: ignoreActors: 1)
		(earring init:)
		(plane setRect: 0 15 319 154)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (ByteArray new: 40))
		(cond
			((== theVerb 2) ; Talk
				(if (gEgo has: 0) ; badge
					(localproc_2 2 2 6)
				else
					(switch (++ local78)
						(1
							(localproc_2 2 2)
						)
						(2
							(localproc_2 2 2 2)
						)
						(else
							(localproc_2 2 2 3)
						)
					)
				)
			)
			((not (Message msgGET 460 2 theVerb 0 1 (temp0 data:)))
				(localproc_2 2 15)
			)
			(else
				(localproc_2 2 theVerb)
			)
		)
		(temp0 dispose:)
	)

	(method (dispose)
		(gGlobalSound2 fade:)
		((ScriptID 0 11) dispose:) ; iconExit
		(gGraphMenuBar state: (& (gGraphMenuBar state:) $fffb))
		(gCurRoom curPic: 440)
		(super dispose:)
	)
)

(instance cavScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 30)
				(= register 0)
				(= local72 (Random 4 6))
				(cav cel: 0 setLoop: local72)
				(localproc_0 register (+ local72 440))
			)
			(1
				(if (== (++ register) (+ (cav lastCel:) 1))
					(= register 0)
					(if (not (Random 0 3))
						(= local72 (Random 4 8))
					)
				)
				(cav loop: local72 cel: register)
				(localproc_0 register (+ local72 440))
				(if (not local73)
					(-- state)
				)
				(if
					(or
						(and (== local72 4) (OneOf register 0 4))
						(and (== local72 5) (OneOf register 2 5))
						(and (== local72 6) (OneOf register 2 6))
					)
					(= ticks 40)
				else
					(= ticks 1)
				)
			)
			(2
				(gGame handsOff:)
				(if global170
					(= global170 0)
					(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				)
				(cav setLoop: 0 cel: 0)
				(for ((= temp0 1)) (<= temp0 10) ((++ temp0))
					([local4 temp0] dispose:)
					(= [local4 temp0] 0)
				)
				(if (== local73 2)
					(Load rsMESSAGE 440)
					([local4 0] dispose:)
					(= [local4 0] 0)
					(= state 16)
				else
					(if (> gHowFast 3)
						([local4 0] cycleSpeed: 4)
					else
						([local4 0] cycleSpeed: 2)
					)
					([local4 0] view: 449 setLoop: 0 x: 165 y: 64 cel: 0)
				)
				(= ticks 60)
			)
			(3
				(cav
					view: 452
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 260 60 self
				)
				(Load rsSOUND 441)
			)
			(4
				(cav view: 442 setLoop: 9 cel: 0 setCycle: 0)
				(gGlobalSound2 stop:)
				(sfx number: 441 loop: 1 play:)
				(= ticks 60)
			)
			(5
				(upperSpeaker cel: 0)
				(lowerSpeaker cel: 0)
				(recordPlayer setCycle: 0 cel: 0)
				(cav cel: 0)
				(= ticks 30)
			)
			(6
				(cav setCycle: Beg self)
			)
			(7
				(cav
					view: 452
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 260 66 self
				)
			)
			(8
				(self setScript: clapScr)
			)
			(9
				(self cue:)
			)
			(10
				(gMessager say: 15 4 1 6 self) ; "(PISSED) That's it! FORGET IT! Class dismissed! Everybody out of here!"
			)
			(11
				(self setScript: clapScr)
			)
			(12
				(if (> gHowFast 3)
					([local4 0] cycleSpeed: 4)
				else
					([local4 0] cycleSpeed: 2)
				)
				([local4 0]
					cel: 0
					setPri: ([local4 0] priority:)
					y: (- ([local4 0] y:) 4)
					setCycle: CT 9 1 self
				)
			)
			(13
				(leftDoor setCycle: End self)
			)
			(14
				([local4 0] setCycle: End self)
			)
			(15
				(cav setLoop: 1 cel: 0)
				(= ticks 10)
			)
			(16
				(if (> gHowFast 3)
					([local4 0] cycleSpeed: 6)
				else
					([local4 0] cycleSpeed: 3)
				)
				([local4 0] setLoop: 1 cel: 0 setCycle: End self)
			)
			(17
				(gMessager say: 0 0 17 0 self) ; "(Awright! Now that those girls are out of here, I've got the aerobics babe all to myself!)"
				(gGame changeScore: 7 209)
				(if [local4 0]
					([local4 0] dispose:)
					(= [local4 0] 0)
				)
				(if (!= local73 2)
					(leftDoor setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(18)
			(19
				(gEgo
					normalize: 441
					setPri: 107
					setLoop: 0
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(20
				(gEgo setLoop: 0)
				(= local76 0)
				((gCurRoom script:) cue:)
				(ClearFlag 9)
				(self dispose:)
			)
		)
	)
)

(instance clapScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 3)
				(cav
					view: 442
					cel: 0
					setLoop: 0 1
					cycleSpeed: 6
					setCycle: 0
					setMotion: 0
				)
				(= ticks 10)
			)
			(1
				(cav cel: 1)
				(= ticks 10)
			)
			(2
				(cav cel: 2)
				(= ticks 10)
			)
			(3
				(cav cel: 3)
				(sfx number: 445 loop: 1 play:)
				(= ticks 10)
			)
			(4
				(cav cel: 2)
				(= ticks 10)
			)
			(5
				(if (-- register)
					(-= state 2)
				)
				(cav cel: 3)
				(sfx number: 445 loop: 1 play:)
				(= ticks 10)
			)
			(6
				(cav cycleSpeed: 10 setCycle: Beg self)
			)
			(7
				(self dispose:)
				((cav script:) cue:)
			)
		)
	)
)

(instance deathIcon of DCIcon
	(properties)

	(method (init)
		(if (> gHowFast 3)
			(= cycleSpeed 10)
		else
			(= cycleSpeed 8)
		)
		((= cycler (End new:)) init: self 0)
		(super init: &rest)
	)

	(method (cycle)
		(if gCuees
			(gCuees doit:)
		)
		(switch cel
			(3
				(if (not local0)
					(= local0 1)
					(sfx number: 355 loop: 1 play:)
				)
			)
			(7
				(if (not local1)
					(= local1 1)
					(sfx number: 355 loop: 1 play:)
				)
			)
			(12
				(if (not local2)
					(= local2 1)
					(sfx number: 814 loop: 1 play:)
				)
			)
			(14
				(if (not local3)
					(= local3 1)
					(= local0 0)
					(= local1 0)
					(= local2 0)
					(sfx number: 0 stop:)
					(DoAudio audPLAY 82 2 0 1 1) ; "As the last breath of life slowly ebbs from your body, you think to yourself, "So what? Those are tits to die for!""
				)
			)
		)
		(super cycle:)
	)
)

(instance frameIcon of DCIcon
	(properties
		view 1850
	)

	(method (init)
		(super init: &rest)
		(cycler dispose:)
		(= cycler 0)
	)
)

