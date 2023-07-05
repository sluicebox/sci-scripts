;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use n079)
(use n082)
(use LarryRoom)
(use Print)
(use Inset)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	[local0 11]
	[local11 11] = [{KGirl} {DGirl} {HGirl} {CGirl} {IGirl} {BGirl} {EGirl} {AGirl} {FGirl} {GGirl} {JGirl}]
	[local22 11] = [242 239 160 199 200 222 217 156 114 143 218]
	[local33 11] = [83 61 97 56 86 45 71 47 80 81 100]
	[local44 11] = [229 229 153 192 192 210 206 144 104 133 209]
	[local55 11] = [80 58 90 55 82 44 67 46 78 79 98]
	local66
	local67
	local68
	local69
	local70
	local71 = 5
	local72
	local73
	local74
	local75
	local76
	local77 = -1
	local78
)

(procedure (localproc_0 param1 param2 &tmp temp0 [temp1 20])
	(if (not (IsObject [local0 0]))
		(return)
	)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		([local0 temp0] cel: param1)
		(if (> argc 1)
			([local0 temp0] view: param2)
		)
	)
	(if (and local68 (!= local68 ([local0 0] view:)))
		(UnLoad 128 local68)
		(= local68 ([local0 0] view:))
	)
)

(procedure (localproc_1 param1 &tmp temp0 [temp1 20])
	(= local70 1)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		((= [local0 temp0] (Girl new:))
			name: [local11 temp0]
			view: 445
			setLoop: temp0
			cel: 0
			x: [local44 temp0]
			y: [local55 temp0]
			signal: 18432
			init:
			setCycle: 0
			approachX: [local22 temp0]
			approachY: [local33 temp0]
			noun: 14
			approachVerbs: 4 1 2 5 6 ; Do, Look, Talk, Take, Zipper
		)
	)
	(if (IsObject param1)
		(param1 cue:)
	)
)

(instance rm440 of LarryRoom
	(properties
		noun 1
		picture 440
		style 15
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
		(recordPlayer init: approachVerbs: 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
		(rightDoor init: approachVerbs: 4) ; Do
		(leftDoor init: approachVerbs: 4) ; Do
		(switch gPrevRoomNum
			(455
				(gEgo init: normalize: 441 0 posn: 241 69)
			)
			(230
				(gEgo init: normalize: 441 1 x: 283 y: 98)
				(rightDoor cel: (rightDoor lastCel:))
				(gCurRoom setScript: enterThruDoorScr 0 2)
			)
			(460
				(gEgo init: normalize: 441 0 x: 239 y: 69)
				(cav init: approachVerbs: 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(self setScript: talkToCavScr 0 1)
			)
			(else
				(gEgo init: normalize: 441 3 x: 120 y: 132)
				(leftDoor cel: (leftDoor lastCel:))
				(gCurRoom setScript: enterThruDoorScr 0 1)
			)
		)
		(UnLoad 128 900)
		(gGlobalSound2 stop:)
		(cond
			((or (IsFlag 210) (IsFlag 66)))
			((and (IsFlag 9) (not (OneOf gPrevRoomNum 460 455)))
				(gGlobalSound2 number: 440 loop: -1 play: 127)
				(localproc_1)
				(recordPlayer setCycle: Fwd)
				(upperSpeaker init: approachVerbs: 4 5) ; Do, Take
				(lowerSpeaker init: approachVerbs: 4 5) ; Do, Take
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
		(= local76 1)
	)

	(method (doit &tmp [temp0 21])
		(if (and (not local70) (== (gEgo view:) 441))
			(switch (gEgo cel:)
				(0
					(if (== local76 2)
						(= local76 1)
						(sfx number: 346 loop: 1 play:)
					)
				)
				(3
					(if (== local76 1)
						(= local76 2)
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

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local70
						(gMessager say: 1 1 1) ; "What a wonderful place you've stumbled upon, Larry! A room filled with hot sweaty women dressed in skimpy tight-fitting outfits!!"
						(return 1)
					)
					(local69
						(gMessager say: 1 1 3) ; "The aerobics room is empty now, except for that beautiful aerobics instructor standing on the small stage near the east end of the room."
						(return 1)
					)
					(else
						(return (super doVerb: theVerb))
					)
				)
			)
			(6 ; Zipper
				(if local70
					(gMessager say: 1 6) ; "This is not a good place to expose yourself. These gals look tough!"
				else
					(gMessager say: 1 6 4) ; "Now? The girls are gone!"
				)
				(return 1)
			)
			(2 ; Talk
				(cond
					(local70
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

	(method (changeState newState &tmp temp0)
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
		x 260
		y 66
		noun 2
		approachX 239
		approachY 69
		view 442
		loop 5
		signal 18432
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
				(if (IsObject [local0 0])
					(gMessager say: 2 2 1 0) ; "Perhaps I shouldn't bother her; she's quite focused on her work."
				else
					(gCurRoom setScript: talkToCavScr)
				)
			)
			(1 ; Look
				(if (IsObject [local0 0])
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
		(= local69 1)
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
			setOnMeCheck:
				2
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
					(local70
						(gMessager say: 15 1 1) ; "There is one empty aerobic step just waiting for another overweight body."
					)
				)
			)
			(4 ; Do
				(if local70
					(gCurRoom setScript: larryScr 0 0)
				else
					(gCurRoom setScript: larryScr 0 -2)
				)
			)
			(5 ; Take
				(if local70
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
		x 262
		y 95
		noun 16
		approachX 255
		approachY 97
		view 440
		loop 1
		signal 18448
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 127
		y 107
		noun 4
		approachX 121
		approachY 105
		view 440
		signal 18448
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
				(gEgo setMotion: MoveTo 121 126 self)
				(gGlobalSound2 fade: 0 10 10 1)
			)
			(2
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

	(method (init)
		(Graph grDRAW_LINE nsTop nsLeft nsTop nsRight 1 21)
		(Graph grDRAW_LINE nsBottom nsLeft nsBottom nsRight 1 21)
		(Graph grDRAW_LINE nsTop nsLeft nsBottom nsLeft 1 21)
		(Graph grDRAW_LINE nsTop nsRight nsBottom nsRight 1 21)
		(Graph grUPDATE_BOX nsTop nsLeft (+ nsBottom 1) (+ nsRight 1) 1)
		(super init:)
	)

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
		x 270
		y 41
		noun 3
		sightAngle 10
		approachX 258
		approachY 41
		view 440
		loop 2
		signal 18448
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 277 49 265 49 262 34 275 34
					yourself:
				)
		)
		(super init:)
	)

	(method (doit &tmp [temp0 20])
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
		x 258
		y 106
		noun 3
		sightAngle 10
		approachX 254
		approachY 106
		view 440
		loop 2
		signal 18448
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 119
		y 85
		view 460
		loop 4
		priority 2
		signal 18448
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance titCue of cObj
	(properties)

	(method (cue)
		(= local74 0)
	)
)

(instance fastForwardCue of cObj
	(properties)

	(method (cue &tmp [temp0 40] [temp40 40] temp80)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(Message msgGET 440 0 0 23 1 @temp0) ; "Get those girls out of here!"
		(Message msgGET 440 0 0 24 1 @temp40) ; "You are so impatient!"
		(= temp80 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 170 55)
		(if
			(Print
				font: gUserFont
				addTitle: @temp40
				addText: @temp0 0 0
				x: 30
				y: 20
				addButton: 1 0 0 28 1 120 25 440 ; "Yes"
				addButton: 0 0 0 27 1 0 25 440 ; "Oops"
				init:
			)
			(larryScr register: 5)
			(= local67 2)
			(gGlobalSound2 stop:)
		else
			(= global170 self)
			((ScriptID 0 8) enable:) ; icon5
		)
		(gGame setCursor: temp80)
	)
)

(instance rightBoob of Feature
	(properties
		y 1
		noun 4
		modNum 460
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
			(gMessager say: 4 theVerb 0 0 0 460)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance leftBoob of Feature
	(properties
		y 1
		noun 1
		modNum 460
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
			(gMessager say: 1 theVerb 0 0 0 460)
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
			setOnMeCheck:
				2
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
						(gMessager say: 6 4 0 0 0 460) ; "I see you're interested in my employee identification card."
					)
					(local74
						(gGame setScript: takeOffShirtScr)
					)
					(else
						(= local74 1)
						(titTimer setReal: titCue 4)
						(gMessager say: 6 4 6 0 0 460) ; "Hey, watch it!"
					)
				)
			)
			(1 ; Look
				(gMessager say: 6 theVerb 0 0 0 460) ; "How odd! Cav's t-shirt seems to say "Homo!""
			)
			(5 ; Take
				(gMessager say: 6 theVerb 0 0 0 460) ; "If you think you're man enough to take the shirt off my back, I'd be more than willing to prove that you're not!"
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
			setOnMeCheck:
				2
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
				(gMessager say: 8 theVerb 0 0 0 460) ; "Like this face? It's all muscle too."
			)
			(1 ; Look
				(if local73
					(gMessager say: 8 theVerb 4 0 0 460) ; "Cavaricchi is beautiful, in a handsome sort of way!"
				else
					(= local73 1)
					(gMessager say: 8 theVerb 0 0 0 460) ; "Cavaricchi Vuarnet's face is angular and handsome, with the determined, firm-jawed look so typical of aerobics instructors and Neo-Nazis."
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
			setOnMeCheck:
				2
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
			(gMessager say: 9 theVerb 0 0 0 460)
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
			setOnMeCheck:
				2
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
			(gMessager say: 10 theVerb 0 0 0 460)
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
			setOnMeCheck:
				2
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
			(gMessager say: 10 theVerb 0 0 0 460)
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
			setOnMeCheck:
				2
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
			(gMessager say: 10 theVerb 0 0 0 460)
		else
			(closeUpInset doVerb: theVerb)
		)
	)
)

(instance titTimer of Timer
	(properties)

	(method (cue)
		(gMessager say: 0 0 7 0 0 460) ; "Nice to meet you, little man. My name is Cavaricchi Vuarnet. And, based upon your proven athletic abilities, your name should be on my class roster."
	)
)

(instance punchTimer of Timer
	(properties)

	(method (cue)
		(closeUpInset dispose:)
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
				(gMessager say: 7 5 10 1 3 self 460) ; "Oh, no! Look! Your badge got caught on my finger. Okay, now I have to amputate my finger, or you can give me your badge! Either way, you pick. I don't care!"
			)
			(2
				(theBadge dispose:)
				(gGame changeScore: 15 210)
				(gEgo get: 0) ; badge
				(= seconds 4)
			)
			(3
				(gMessager say: 7 5 10 4 7 self 460) ; "In fact, I have an idea: let's meet later today for a sauna together? Bring your best girl and meet me in the Swedish Sauna. We'll double-date!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upperLight of Feature
	(properties
		noun 21
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
				(= local77 (gNarrator talkWidth:))
				(gNarrator x: 5 y: 10 talkWidth: 120)
				(gCurRoom setInset: closeUpInset self)
			)
			(4
				(gNarrator x: -1 y: -1 talkWidth: local77)
				(if (IsFlag 6)
					(gGame handsOff:)
					(gEgo
						posn: 239 69
						ignoreActors: 1
						setLoop: 8
						cel: 0
						setCycle: 0
						hide:
					)
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
					(Load rsVIEW 451)
					(gGlobalSound2 stop:)
					(= ticks 120)
				else
					(self dispose:)
				)
			)
			(5
				(Load rsSOUND 443)
				(cav setCycle: CT 5 1 self)
			)
			(6
				(sfx number: 443 loop: 1 play:)
				(ShakeScreen 1 ssUPDOWN)
				(= ticks 4)
			)
			(7
				(cav cel: 6)
				(gEgo
					show:
					view: 451
					setLoop: 0
					cel: 0
					x: 239
					y: 69
					scaleSignal: 1
					scaleX: 12
					scaleY: 12
					setCycle: 0
					forceUpd:
				)
				(= ticks 4)
			)
			(8
				(gEgo x: 229 y: 68 scaleX: 21 scaleY: 21 forceUpd:)
				(= ticks 4)
			)
			(9
				(gEgo x: 204 y: 69 scaleX: 46 scaleY: 46 forceUpd:)
				(= ticks 4)
			)
			(10
				(gEgo x: 163 y: 69 scaleX: 80 scaleY: 80 forceUpd:)
				(cav
					view: 452
					setLoop: 0
					setMotion: MoveTo (+ (cav x:) 10) (cav y:) cav
				)
				(= ticks 4)
			)
			(11
				(gEgo x: 104 y: 68 setScale: 0 forceUpd:)
				(= ticks 4)
			)
			(12
				(sfx number: 444 loop: 1 play:)
				(gEgo setLoop: 1 setPri: 13 setMotion: 0 forceUpd:)
				(ShakeScreen 1 ssUPDOWN)
				(= ticks 120)
			)
			(13
				(EgoDead 1 self)
			)
			(14
				(ClearFlag 6)
				(gEgo normalize: 441 0 posn: 239 69)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeUpInset of Inset
	(properties
		picture 460
		y -2
		disposeNotOnMe 1
		noun 2
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (init)
		(gCurRoom curPic: 460)
		(super init: &rest)
		(gGame handsOn:)
		((ScriptID 0 11) init: gCurRoom) ; iconExit
		(rightArm init:)
		(leftArm init:)
		(chest init:)
		(face init:)
		(if (not (IsFlag 210))
			(theBadge init: y: 133)
		)
		(shirt init:)
		(rightBoob init:)
		(leftBoob init:)
		(tits init: hide:)
		(earring init:)
		(if (not (IsFlag 62))
			(SetFlag 62)
			(titTimer setCycle: titTimer 3)
		)
	)

	(method (doVerb theVerb &tmp [temp0 40])
		(cond
			((== theVerb 2) ; Talk
				(if (gEgo has: 0) ; badge
					(gMessager say: 2 2 6 0 0 460) ; "Were you serious in your invitation, Cav?"
				else
					(switch (++ local72)
						(1
							(gMessager say: 2 2 0 0 0 460) ; "Cav, do you think it's possible for a hunk like me to develop an even better body?"
						)
						(2
							(gMessager say: 2 2 2 0 0 460) ; "Which do you admire more: my body or my mind?"
						)
						(else
							(gMessager say: 2 2 3 0 0 460) ; "How did you end up with such a great job, Cav?"
						)
					)
				)
			)
			((not (Message msgGET 460 2 theVerb 0 1 @temp0))
				(gMessager say: 2 15 0 0 0 460) ; "What are you, stupid? Why would I want that? Get outta here!"
			)
			(else
				(gMessager say: 2 theVerb 0 0 0 460)
			)
		)
	)

	(method (dispose)
		(gGlobalSound2 fade:)
		((ScriptID 0 11) dispose:) ; iconExit
		(gCurRoom curPic: 440)
		(super dispose:)
	)
)

(instance theBadge of View
	(properties
		x 155
		y 133
		noun 7
		modNum 460
		view 460
		loop 5
		priority 3
		signal 18448
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 147 139 158 125 166 125 174 135 169 139
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 7 theVerb 0 0 0 460) ; "Lucky badge! You'd love to hang out with company like that!"
			)
			(1 ; Look
				(if (not local78)
					(= local78 1)
					(gMessager say: 7 1 0 0 0 460) ; "Cavaricchi's badge proclaims her an official employee of La Costa Lotta, entitled to all the rights and privileges thereof..."
				else
					(gMessager say: 7 1 5 0 0 460) ; "What an impressive set of credentials you have, Cavaricchi!"
				)
			)
			(2 ; Talk
				(gMessager say: 7 2 0 0 0 460) ; "You'd better keep your mouth away from there, if you know what's good for you!"
			)
			(5 ; Take
				(switch (++ local75)
					(1
						(gMessager say: 7 5 8 0 0 460) ; "I couldn't help but notice your Employee ID badge, Cav. What a lovely likeness of you!"
					)
					(2
						(gMessager say: 7 5 9 0 0 460) ; "Badges? Ve don' need no steenkin' badges!"
					)
					(else
						(gGame setScript: takeBadgeScr)
					)
				)
			)
			(else
				(closeUpInset doVerb: theVerb)
			)
		)
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
		x 259
		y 55
		noun 6
		approachX 249
		approachY 51
		view 440
		loop 3
		signal 18448
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

(instance playARecordScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 30] temp30 temp31 temp32)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 0 0 0 self) ; "Peering through Cav's record collection, you find one album that particularly excites you: the soundtrack from "Leisure Suit Larry 6: Shape Up or Slip Out!""
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(Message msgGET 440 5 0 5 1 @temp0) ; "Shape Up or Slip Out!"
				(= temp31 (gSystemWindow color:))
				(= temp32 (gSystemWindow back:))
				(gSystemWindow color: 56 back: 75)
				(Print
					width: 140
					font: 999
					addTitle: @temp0
					x: -1
					y: 11
					addButton: 120 5 0 6 1 0 0 440 ; "The Larry Theme"
					addButton: 230 5 0 7 1 115 0 440 ; "Air for the G-String"
					addButton: 380 5 0 9 1 0 13 440 ; "Shock Your Booty"
					addButton: 440 5 0 10 1 115 13 440 ; "2 Rump 2 Pump"
				)
				(= temp30
					(Print
						addButton: 442 5 0 11 1 0 26 440 ; "Switch Hitt'n Kitt'n"
						addButton: 511 5 0 12 1 115 26 440 ; "Harry Palm Blues"
						addButton: 514 5 0 13 1 0 39 440 ; "Cell Block Love"
						addButton: 560 5 0 14 1 115 39 440 ; "Un Noche en Parlier"
						addButton: 860 5 0 15 1 0 52 440 ; "Samba de Hooters"
						addButton: 320 5 0 16 1 115 52 440 ; "Spanish Surprise"
						addButton: 420 5 0 18 1 0 65 440 ; "Larry Be Bad!"
						addButton: 580 5 0 20 1 115 65 440 ; "Muskrat Lust"
						addButton: 430 5 0 19 1 0 78 440 ; "No Pain, No Gain"
						addButton: 840 5 0 21 1 115 78 440 ; "Twist Till It Hurts"
						addButton: 310 5 0 8 1 0 (proc79_4 91 91 99 91 91) 440 ; "Hard is Good, Right?"
						addButton: ; "Not Ravel's Bolero"
							337
							5
							0
							22
							1
							115
							(proc79_4 91 91 99 91 91)
							440
						init:
					)
				)
				(gSystemWindow color: temp31 back: temp32)
				(gGlobalSound2 number: temp30 loop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance larryScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
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
				((ScriptID 0 8) enable:) ; icon5
				(= cycles 2)
			)
			(5
				(if (OneOf (cav loop:) 4 5 6)
					(gEgo
						view: 443
						setLoop: (- (cav loop:) 4)
						setCycle: Fwd
						cycleSpeed: (Random 6 9)
					)
				else
					(gEgo view: 441 setLoop: 8 cel: 0 setCycle: 0)
				)
				(cond
					((and (!= (cav loop:) 8) (not (-- local71)))
						(gMessager say: 15 4 1 (++ register) self)
						(= local71 (Random 4 6))
					)
					((== register 3)
						(= local71 (= cycles 1))
					)
					(else
						(= ticks 90)
					)
				)
				(if (< register 5)
					(-- state)
				else
					(if (not local67)
						(= local67 1)
					)
					(= global170 0)
					((ScriptID 0 8) disable:) ; icon5
					(gEgo normalize: 441 setLoop: 0 setCycle: 0)
				)
			)
			(6)
			(7
				(= global166 (ScriptID 0 3)) ; icon0
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cavScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(OneOf state 9 11)
				(OneOf (cav cel:) 3 5 7)
				(not (sfx handle:))
			)
			(sfx number: 445 loop: 1 play:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 30)
				(= register 0)
				(= local66 (Random 4 6))
				(cav cel: 0 setLoop: local66)
				(localproc_0 register (+ local66 440))
			)
			(1
				(if (== (++ register) (+ (cav lastCel:) 1))
					(= register 0)
					(if (not (Random 0 3))
						(= local66 (Random 4 8))
					)
				)
				(cav loop: local66 cel: register)
				(localproc_0 register (+ local66 440))
				(if (not local67)
					(-- state)
				)
				(if
					(or
						(and (== local66 4) (OneOf register 0 4))
						(and (== local66 5) (OneOf register 2 5))
						(and (== local66 6) (OneOf register 2 6))
					)
					(= ticks 40)
				else
					(= ticks 1)
				)
			)
			(2
				(cav setLoop: 0 cel: 0)
				(for ((= temp0 1)) (<= temp0 10) ((++ temp0))
					([local0 temp0] dispose:)
					(= [local0 temp0] 0)
				)
				(if (== local67 2)
					(Load rsMESSAGE 440)
					([local0 0] dispose:)
					(= [local0 0] 0)
					(= state 16)
				else
					([local0 0]
						view: 449
						setLoop: 0
						x: 165
						y: 64
						cel: 0
						cycleSpeed: 10
					)
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
				(upperSpeaker cel: 0 stopUpd:)
				(lowerSpeaker cel: 0 stopUpd:)
				(recordPlayer setCycle: 0 cel: 0 stopUpd:)
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
				(cav view: 442 cycleSpeed: 8 cel: 0 setLoop: 0)
				(= ticks 30)
			)
			(9
				(cav setCycle: End self)
			)
			(10
				(gMessager say: 15 4 1 6 self) ; "(PISSED) That's it! FORGET IT! Class dismissed! Everybody out of here!"
			)
			(11
				(cav cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(12
				(cav cel: 0)
				([local0 0] cycleSpeed: 12 cel: 0 setCycle: CT 9 1 self)
			)
			(13
				(leftDoor setCycle: End self)
			)
			(14
				([local0 0] setCycle: End self)
			)
			(15
				(cav setLoop: 1 cel: 0)
				(= ticks 10)
			)
			(16
				([local0 0] setLoop: 1 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(17
				(gMessager say: 0 0 17 0 self) ; "(Awright! Now that those girls are out of here, I've got the aerobics babe all to myself!)"
				(gGame changeScore: 7 209)
				(if [local0 0]
					([local0 0] dispose:)
					(= [local0 0] 0)
				)
				(if (!= local67 2)
					(leftDoor setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(18)
			(19
				(gEgo
					normalize: 441
					setLoop: 0
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(20
				(= local70 0)
				((gCurRoom script:) cue:)
				(ClearFlag 9)
				(self dispose:)
			)
		)
	)
)

