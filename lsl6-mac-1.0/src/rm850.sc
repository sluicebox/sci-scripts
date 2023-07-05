;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm850 0
)

(instance rm850 of LarryRoom
	(properties
		noun 1
		picture 850
	)

	(method (init)
		(ClearFlag 84)
		((ScriptID 0 11) init: self) ; iconExit
		(bang init:)
		(gun init:)
		(pouch init:)
		(chair init:)
		(panels init:)
		(aWindow init:)
		(monitors init:)
		(monitor1 init: setCycle: Fwd)
		(monitor2 init: setCycle: Fwd)
		(monitor3 init: setCycle: Fwd)
		(monitor4 init: setCycle: Fwd)
		(gGame handsOn:)
		(fuzz init: setCycle: Fwd)
		(super init: &rest)
		(if (!= ((gInventory at: 18) owner:) gCurRoomNum) ; handcuffs
			(minusHandcuffs init:)
		else
			(handcuffs
				init:
				setOnMeCheck:
					2
					((Polygon new:)
						type: PTotalAccess
						init: 161 67 157 96 145 93 148 67
						yourself:
					)
			)
		)
		(if (IsFlag 18)
			(gGlobalSound1 number: 360 loop: -1 play:)
			(shower init: setCycle: Fwd)
		else
			(gGlobalSound1 number: 850 loop: -1 play:)
			(gGlobalSound2 number: 851 loop: -1 play:)
			(eyeMonitor init:)
		)
		((ScriptID 0 11) init: 800) ; iconExit
		(gNarrator x: 10 y: 72 talkWidth: 290)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: stopLarryScr 0 1)
				(return 1)
			)
			(2 ; Talk
				(gMessager
					say:
						noun
						theVerb
						(cond
							((IsFlag 18) 1)
							((< (+ global191 1) 5)
								(switch (++ global191)
									(1 2)
									(2 3)
									(3 6)
									(4 4)
								)
							)
							(else 5)
						)
				)
			)
			(else
				(return (super doVerb: theVerb))
			)
		)
	)

	(method (dispose)
		(ClearFlag 95)
		(gNarrator x: -1 y: -1 talkWidth: 0)
		(gGlobalSound1 fade:)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose:)
	)
)

(instance stopLarryScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(blockLarry init: setCycle: End self)
				(SetFlag 95)
			)
			(1
				(blockLarry stopUpd:)
				(= cycles 2)
			)
			(2
				(if register
					(gMessager say: 1 4 0 0 self) ; "Hey, dude! I say, don't touch my equipment! I've got a gun. Don't make me learn how to use it!"
				else
					(gMessager say: 5 4 (if (not (SetFlag 91)) 0 else 7) 0 self)
				)
			)
			(3
				(blockLarry startUpd: setCycle: Beg self)
			)
			(4
				(ClearFlag 95)
				(blockLarry dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance missleDeathScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 5 0 0 self) ; "Without thinking twice, without blinking an eye, without moving from his stool, Daryl raises one solitary finger and subtly depresses one particular button."
			)
			(1
				(= ticks 10)
			)
			(2
				(triggerFinger init: setCycle: End self)
			)
			(3
				(SetFlag 2)
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance takeHandcuffsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(minusHandcuffs init:)
				(handcuffs dispose:)
				(gEgo get: 18) ; handcuffs
				(= cycles 2)
			)
			(1
				(gGame changeScore: 15 273)
				(gMessager say: 3 5 1 0 self) ; "Daryl is so absorbed in your new television spectacular, you are able to remove the handcuffs without his detection."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bang of Feature
	(properties
		y 1
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 143 27 143 4 176 3 174 33 182 42 189 68 225 61 230 67 191 85 208 102 201 139 179 139 184 113 171 109 155 108 155 139 138 139 134 109 126 97 118 74 125 36
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 1) (IsFlag 18)) ; Look
				(gMessager say: noun theVerb 1)
			)
			((== theVerb 2) ; Talk
				(rm850 doVerb: theVerb)
			)
			((== theVerb 4) ; Do
				(gCurRoom setScript: stopLarryScr 0 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance handcuffs of Feature
	(properties
		y 2
		noun 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Take
			(if (and (not (gEgo has: 18)) (not (IsFlag 208)) (IsFlag 18)) ; handcuffs
				(gCurRoom setScript: takeHandcuffsScr)
			else
				(gCurRoom setScript: missleDeathScr)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pouch of Feature
	(properties
		x 122
		y 2
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 120 66 136 70 127 88 112 86
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Take
			(SetFlag 84)
			(gCurRoom setScript: missleDeathScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gun of Feature
	(properties
		y 2
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 177 79 166 100 159 97 166 71
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Take
			(SetFlag 84)
			(gCurRoom setScript: missleDeathScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chair of Feature
	(properties
		y 2
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 163 107 175 122 175 139 166 139 169 126 162 115 157 113 156 138 149 138 151 111 140 111 138 139 130 140 126 134 129 116 137 107
					yourself:
				)
		)
	)
)

(instance panels of PolyFeature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 67 28 67 103 50 122 52 116 71 108 71 37 92 0 113
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 319 57 319 89 207 76 232 66 226 61 188 67 186 55
					yourself:
				)
		)
	)
)

(instance aWindow of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 0 0 60 0 63 47 0 62 yourself:)
		)
	)
)

(instance monitors of PolyFeature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 29 127 30 125 46 105 47
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 319 4 319 47 308 49 308 2
					yourself:
				)
		)
	)
)

(instance eyeMonitor of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 231 6 231 41 189 41 188 6
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance monitor1 of Prop
	(properties
		x 244
		y 9
		noun 6
		view 853
		cel 5
	)
)

(instance monitor2 of Prop
	(properties
		x 276
		y 8
		noun 6
		view 853
		loop 1
		cel 2
	)
)

(instance monitor3 of Prop
	(properties
		x 276
		y 33
		noun 6
		view 853
		loop 3
		cel 13
	)
)

(instance monitor4 of Prop
	(properties
		x 245
		y 33
		noun 6
		view 853
		loop 2
		cel 3
		cycleSpeed 7
	)
)

(instance fuzz of Prop
	(properties
		x 105
		y 6
		noun 6
		view 853
		loop 4
		cel 2
		priority 6
		signal 16
	)
)

(instance shower of Prop
	(properties
		x 193
		y 14
		noun 10
		view 853
		loop 5
		cel 2
		priority 26
		signal 16
		cycleSpeed 7
	)
)

(instance minusHandcuffs of View
	(properties
		x 146
		z -73
		view 850
		loop 1
	)
)

(instance triggerFinger of Prop
	(properties
		x 210
		y 59
		view 850
		cel 8
		priority 3
		signal 16
		cycleSpeed 10
	)
)

(instance blockLarry of Actor
	(properties
		x 125
		y 9
		view 850
		loop 2
		priority 3
		signal 16
	)
)

