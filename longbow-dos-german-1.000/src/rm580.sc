;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Game)
(use System)

(public
	rm580 0
)

(local
	local0
)

(instance rm580 of Rm
	(properties
		picture 580
		style 100
	)

	(method (init)
		(super init:)
		(AddToFeatures theMon theRoad1 theRoad2 theRock theFen theArea)
		(= local0
			(switch gDisguiseNum
				(0 67) ; outlaw
				(1 69) ; beggar
				(2 74) ; jewler (no rouge)
				(3 74) ; jewler (rouge)
				(4 68) ; yeoman
				(5 50) ; abbey monk
				(6 48) ; fens monk
			)
		)
		(HandsOff)
		(if
			(and
				(== gDisguiseNum 0) ; outlaw
				(< (Abs (- (GetTime 1) global129)) 100) ; SysTime12
				(!= (- (GetTime 1) global129) 0) ; SysTime12
				(!= global129 0)
			)
			(gCurRoom setScript: egads)
		else
			(= global129 0)
		)
		(if (== gPrevRoomNum 590)
			(NormalEgo 2 local0 local0)
			(gEgo
				posn: 183 176
				xStep: 1
				yStep: 1
				setPri: 11
				signal: 16
				init:
				setCycle: Walk
				setScript: fromMonastery
			)
		else
			(NormalEgo 2)
			(gEgo posn: 100 240 init: setScript: toOverLook)
		)
		(gEgo actions: egoActions)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((== (gEgo edgeHit:) 3)
				(gEgo setScript: backToMap)
			)
			((== (gEgo onControl: 1) 2)
				(gEgo setScript: goDown)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(gRgnMusic2 fade: 0 20 12 1)
		(super dispose: &rest)
	)
)

(instance theMon of Feature
	(properties
		lookStr 2 ; "A grim, well-built Norman fortress of stone, converted by this Order of militant Monks into a monastery."
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 139 85 139 68 160 58 212 60 212 73 193 88
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: goDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theFen of Feature
	(properties
		lookStr 3 ; "The Monastery sits in the midst of the Fens, a body of dark, swampy water with an evil reputation."
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 3 69 23 54 44 46 20 39 104 34 61 24 120 21 126 16 259 19 291 29 291 35 258 47 292 81 303 111 259 122 216 123 168 114 142 114 66 110 84 105 52 100 2 82
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: goDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theArea of Feature
	(properties
		nsBottom 189
		nsRight 319
		lookStr 4 ; "The Fens are surrounded by boggy ground. It would be dangerous to tread too far from the safety of the path."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: goDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theRoad1 of Feature
	(properties
		lookStr 5 ; "This looks to be the only path leading to the edge of the Fens."
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 143 115 149 115 147 119 139 123 140 129 180 152 185 157 174 159 173 154 141 136 136 129 136 124
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: goDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theRoad2 of Feature
	(properties
		lookStr 5 ; "This looks to be the only path leading to the edge of the Fens."
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 159 167 164 172 244 182 232 187 234 189 199 189 180 181 159 178 149 178 140 172 152 168
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: goDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theRock of Feature
	(properties
		lookStr 6 ; "From this high, rocky promontory I can see the Monastery and all of the fens surrounding it."
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 13 189 13 176 21 165 27 161 91 164 134 179 141 171 164 163 192 155 222 156 253 161 270 162 319 155 319 189
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance goDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 166 260 self)
			)
			(1
				(NormalEgo 2 local0 local0)
				(gEgo
					setStep: 1 1
					setMotion:
						DPath
						217
						219
						212
						188
						185
						177
						151
						173
						149
						171
						self
				)
			)
			(2
				(gEgo setPri: 11 setMotion: DPath 152 170 183 176 self)
			)
			(3
				(gCurRoom newRoom: 590)
			)
		)
	)
)

(instance toOverLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 75 188 self)
			)
			(1
				(gEgo setMotion: MoveTo 83 172 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance backToMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(1
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance fromMonastery of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rm580 south: 0)
				(gEgo setPri: 11 setMotion: DPath 152 170 149 171 self)
			)
			(1
				(gEgo
					setPri: -1
					setMotion: DPath 151 173 185 177 212 188 230 220 self
				)
			)
			(2
				(NormalEgo 2)
				(gEgo posn: 166 240 setMotion: MoveTo 83 172 self)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egads of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic2 number: 583 loop: -1 play: 75)
				(= ticks 60)
			)
			(1
				(Say 1580 0 self) ; "I can still hear the alarm being sounded in the Monastery. The place will be an ant's nest of unrest."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(switch invItem
					(1 ; horn
						(if
							(and
								(< (Abs (- (GetTime 1) global129)) 100) ; SysTime12
								(!= (- (GetTime 1) global129) 0) ; SysTime12
								(!= global129 0)
							)
							(gDoVerbCode doit: theVerb &rest)
						else
							(gEgo setScript: (ScriptID 603 0)) ; blewIt
							(= global129 (GetTime 1)) ; SysTime12
							1
						)
					)
				)
			)
		)
	)
)

