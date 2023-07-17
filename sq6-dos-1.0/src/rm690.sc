;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm690 0
)

(local
	local0 = 8
)

(instance rm690 of SQRoom
	(properties
		noun 1
		picture 690
	)

	(method (init)
		(gGSound1 number: 600 setLoop: -1 play: setVol: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 66 138 178 138 206 138 266 130 266 109 258 97 232 92 221 87 152 94 92 95 83 86 51 98 67 124
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 180 120 182 135 75 135 63 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 194 101 228 99 238 106 208 113 188 113 172 102
					yourself:
				)
		)
		(super init:)
		(gGame handsOff:)
		(gEgo
			init:
			normalize: 0 692
			setSpeed: local0
			enterRoom: 29 93 55 100 self
		)
		(Load 140 692) ; WAVE
		(drip1 init:)
		(drip2 init:)
		(drip3 init:)
		(drip4 init:)
		(drip5 init:)
		(drip6 init:)
		(drip7 init:)
		(drip8 init:)
		(pool init:)
		(middle init:)
		(topSacks init:)
		(two init:)
		(exit680 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
	)

	(method (dispose)
		(gGSound1 fade: 0 3 1 1)
		(super dispose:)
	)

	(method (doit)
		(cond
			((and (> (gEgo x:) 80) (< (gEgo x:) 220))
				(PalVary 0 695 0 (- (gEgo x:) 80) 64 79) ; PalVaryStart
			)
			((>= (gEgo x:) 220)
				(PalVary 0 695 0 140 64 79) ; PalVaryStart
			)
			(else
				(PalVary 0 695 0 0 64 79) ; PalVaryStart
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(1 ; Look
				(gEgo setScript: sLookRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gEgo setHeading: 135)
		(gGame handsOn:)
	)
)

(instance sLookRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 1 0 1 3 self) ; "And here we have the islands of Langerhans. They're a big deal here in the pancreas."
			)
			(1
				(gEgo setMotion: MoveTo 150 110 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gMessager say: 1 1 0 4 self) ; "It just looks like a uvula warehouse to me."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self cue:)
			)
			(1
				(= cycles 1)
			)
			(2
				(if (== (drip4 cel:) 0)
					(gEgo setMotion: MoveTo 176 115 self)
					(drip4 setScript: 0)
				else
					(self changeState: (- state 1))
				)
			)
			(3
				(gEgo
					cycleSpeed: local0
					view: 691
					posn: 176 126
					setLoop: 0
					setCycle: End self
				)
			)
			(4
				(drip4
					show:
					cycleSpeed: local0
					setCel: 0
					setCycle: CT 12 1 self
				)
			)
			(5
				(drip4 hide:)
				(gEgo
					cycleSpeed: local0
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
				(if (IsFlag 105)
					(gEgo put: 42) ; Eva_Full
					(gEgo get: 43) ; Eva_Full_Both
				else
					(gEgo put: 45 get: 44) ; Eva_Helmet, Eva_Full_Enz
				)
			)
			(6
				(gEgo
					cycleSpeed: local0
					setLoop: 0
					setCel: 100
					setCycle: Beg self
				)
			)
			(7
				(gEgo normalize: 0 692 posn: 176 115)
				(gMessager say: 2 114 0 0 self) ; "You maneuver your helmet beneath the drip and manage to snag a nice little dollop of the stuff."
			)
			(8
				(SetFlag 104)
				(gGame points: 3)
				(gGame handsOn:)
				(drip4 setScript: sDripScript)
				(self dispose:)
			)
		)
	)
)

(instance sDripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide:)
				(= ticks (RandomNumber 100 300))
			)
			(1
				(client show: cycleSpeed: local0 setCycle: End self)
			)
			(2
				(gGSound2 setLoop: 0 number: 692 play:)
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance drip1 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 0
			posn: 85 66
			setScript: (sDripScript new:)
			setPri: 400
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip2 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self
			setLoop: 1
			setCel: 0
			posn: 99 14
			setScript: (sDripScript new:)
			setPri: 400
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip3 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self
			setLoop: 2
			setCel: 0
			posn: 150 13
			setScript: (sDripScript new:)
			setPri: 400
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip4 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setCel: 0 posn: 190 22 setScript: (sDripScript new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip5 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self setLoop: 4 setCel: 0 posn: 158 39 setScript: (sDripScript new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip6 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self setLoop: 5 setCel: 0 posn: 180 45 setScript: (sDripScript new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip7 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self setLoop: 6 setCel: 0 posn: 280 44 setScript: (sDripScript new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drip8 of Prop
	(properties
		noun 2
		view 690
	)

	(method (init)
		(super init:)
		(self setLoop: 7 setCel: 0 posn: 234 40 setScript: (sDripScript new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pool of Feature
	(properties
		noun 4
		sightAngle 40
		x 152
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 86 86 84 95 85 112 89 117 93 128 92 145 86 169 86 189 91 192 98 187 100 190 110 201 113 217 109 216 99 218 89 224 86 230 90 237 95 254 93 261 89 263 91 260 98 260 105 262 107 258 116 258 124 265 132 267 137 253 137 255 126 254 118 247 112 239 109 229 109 221 112 214 118 210 125 211 133 214 137 134 137 126 130 118 125 113 122 118 116 117 108 108 101 97 99 91 98 81 97 76 100 75 104 78 110 80 122 85 123 85 125 72 130 64 134 55 138 38 138 40 134 42 130 53 132 65 130 64 124 62 111 66 103 65 98 59 93
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Your hands won't hold much of that."
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "A nice pool of pancreatic secretions made up of insulin and glucagon fill the bottom of the islands of Langerhans."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance topSacks of Feature
	(properties
		noun 3
		sightAngle 40
		x 159
		y 33
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 35 11 37 27 36 43 28 47 16 55 21 64 21 72 17 70 29 65 42 66 53 74 62 82 67 91 66 101 54 105 50 103 40 101 37 105 30 111 30 117 36 126 38 136 34 139 30 148 35 163 33 174 24 177 12 183 12 189 18 191 29 198 33 209 32 217 23 224 26 226 35 226 47 234 56 243 55 257 34 250 8 267 7 276 22 296 28 311 20 319 0 0 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Despite the overwhelming urge to play Rocky with these cute little dangly things, you are wise enough to realize that you must inflict as little damage as possible to Stellar's interior."
			)
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "These little islets drip a pancreatic enzyme. This is later mixed with some stuff from the gallbladder to make that wonderful green bile antifreeze-looking stuff that humanoid hurlers the universe over have come to know and hate."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance middle of Feature
	(properties
		noun 3
		sightAngle 40
		x 205
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 72 218 76 220 84 217 87 215 93 215 100 215 106 214 108 203 110 193 109 190 104 191 100 194 97 191 90 190 84 194 78 201 74
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Despite the overwhelming urge to play Rocky with these cute little dangly things, you are wise enough to realize that you must inflict as little damage as possible to Stellar's interior."
			)
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "These little islets drip a pancreatic enzyme. This is later mixed with some stuff from the gallbladder to make that wonderful green bile antifreeze-looking stuff that humanoid hurlers the universe over have come to know and hate."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance two of Feature
	(properties
		noun 3
		sightAngle 40
		x 148
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 98 161 97 167 99 172 103 173 106 172 111 171 121 171 126 165 131 160 131 148 128 146 126 146 123 141 125 133 125 129 123 129 118 124 110 127 103 133 99 136 99 142 99 145 100
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Despite the overwhelming urge to play Rocky with these cute little dangly things, you are wise enough to realize that you must inflict as little damage as possible to Stellar's interior."
			)
			(114 ; Eva_Helmet
				(gEgo setScript: sGetStuff)
			)
			(115 ; Eva_Full
				(if (IsFlag 104)
					(gMessager say: 2 115 1) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
				else
					(gEgo setScript: sGetStuff)
				)
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "These little islets drip a pancreatic enzyme. This is later mixed with some stuff from the gallbladder to make that wonderful green bile antifreeze-looking stuff that humanoid hurlers the universe over have come to know and hate."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit680 of ExitFeature
	(properties
		approachX 55
		approachY 100
		nextRoom 680
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 29 62 31 69 35 66 43 66 52 68 57 75 62 75 86 43 98 37 75 40 58 38 49 43 38
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; ExitLeft
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 29 93 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 8)
	)
)

