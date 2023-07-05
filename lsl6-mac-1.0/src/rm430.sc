;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use System)

(public
	rm430 0
)

(local
	local0
	local1
)

(instance rm430 of LarryRoom
	(properties
		noun 16
		picture 430
		horizon 0
		autoLoad 0
	)

	(method (init)
		(leftBreast init:)
		(rightBreast init:)
		(hips init:)
		(legs init:)
		(hands init:)
		(wristBand init:)
		(leftArm init:)
		(rightArm init:)
		(SetFlag 103)
		(neck init:)
		(herMouth init:)
		(herEyes init:)
		(hair init:)
		(chest init:)
		(face init:)
		(if (IsFlag 10)
			(= local1 5)
		)
		(gGlobalSound1 pause: 1)
		(gGame handsOn:)
		(gGlobalSound2 number: 430 play: setLoop: -1)
		((ScriptID 0 11) init: 420 enable:) ; iconExit
		(super init: &rest)
		(if (IsFlag 208)
			(gGame handsOff:)
			(self setScript: giveCuffs)
		else
			(gGame handsOn:)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(12 ; handcuffs
				(gCurRoom setScript: giveCuffs)
			)
			(2 ; Talk
				(switch local1
					(0
						(= temp0 6)
					)
					(1
						(= temp0 7)
					)
					(2
						(= temp0 8)
					)
					(3
						(= temp0 9)
					)
					(4
						(= temp0 10)
						(SetFlag 10)
						(gGame changeScore: 2 207)
					)
					(else
						(= temp0 11)
					)
				)
				(gMessager say: 16 2 temp0)
				(++ local1)
				(return 1)
			)
			(1 ; Look
				(if local0
					(gMessager say: 16 1 1) ; "Something tells you this woman is unlike any you've ever tried before, Larry."
					(return 1)
				else
					(++ local0)
					(gMessager say: 16 1 2) ; "Thunderbird looks to be one tough chick. From her leather outfit to her defiant, challenging gaze, you can tell this is one woman who takes her pleasure seriously. It gives you goose-bumps just thinking about it!"
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 208)
			(gGlobalSound1 stop:)
		else
			(gGlobalSound2 fade: 0 10 10 1)
			(gGlobalSound1 pause: 0 fade: 127 10 5 0)
		)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose:)
	)
)

(instance giveCuffs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 16 12 0 0 self) ; "Look what I brought you, Ms. Thunderbird. A genuine pair of chrome-plated, serial-numbered, auto-latching, inexpensive, resort cop handcuffs!"
			)
			(2
				(gEgo put: 18) ; handcuffs
				(gGame changeScore: 15 208)
				(= ticks 120)
			)
			(3
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance leftBreast of Feature
	(properties
		noun 18
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 147 93 137 91 133 82 135 71 139 68 148 71 152 82 151 88 148 93
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightBreast of Feature
	(properties
		noun 18
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 155 83 151 71 152 61 162 58 171 65 174 78 172 82 165 86 156 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hips of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 194 113 202 107 203 94 195 77 195 73 213 68 222 68 231 75 243 105 217 122 208 122
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance legs of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 228 118 253 109 258 121 278 138 240 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hands of Feature
	(properties
		noun 7
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 133 138 128 131 120 102 125 98 133 97 146 101 148 109 142 111 134 110 146 125 146 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wristBand of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 150 109 148 100 166 99 167 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftArm of Feature
	(properties
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 118 57 123 49 128 48 133 74 132 83 137 93 138 98 124 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightArm of Feature
	(properties
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 168 98 180 94 166 45 174 42 181 52 190 77 194 102 194 106 173 108
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance neck of Feature
	(properties
		noun 11
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 137 53 151 42 162 47 148 63 139 63 136 54
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance herMouth of Feature
	(properties
		y 50
		noun 12
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 129 42 138 42 138 47 130 47
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance herEyes of Feature
	(properties
		y 50
		noun 13
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 133 33 125 33 125 26 146 28 145 34
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hair of Feature
	(properties
		noun 14
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 127 46 115 52 110 29 120 3 144 1 156 7 171 38 163 43 153 39 147 24 122 24
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chest of Feature
	(properties
		noun 18
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 136 63 146 63 162 54 162 60 152 63 151 71 150 74 146 68 137 66
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance face of Feature
	(properties
		y 10
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 122 36 127 27 146 26 152 37 149 45 138 52 129 52
					yourself:
				)
		)
		(super init: &rest)
	)
)

