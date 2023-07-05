;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3013)
(include sci.sh)
(use Main)
(use Location)
(use Button)
(use n1111)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	london_Display_Control 0
)

(instance london_Display_Control of CloseupLocation
	(properties
		noun 10
		heading 270
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(super init: 3107)
		(= plane global116)
		(controlButton1 init:)
	)

	(method (dispose)
		(ClearFlag 102)
		(ClearFlag 103)
		(ClearFlag 104)
		(super dispose:)
	)

	(method (newRoom)
		(if (IsFlag 102)
			(self setScript: turnDisplayOff self)
		else
			(super newRoom: &rest)
		)
	)
)

(instance controlButton1 of Button
	(properties
		x 303
		y 187
		view 3107
		loop 2
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 102)
			(controlButton2 init:)
			(controlButton3 init:)
			(controlButtonA init:)
			(controlButtonB init:)
			(controlButtonC init:)
			(controlButtonD init:)
			(controlButtonE init:)
			(solar_System init:)
			(rama_Wire_Frame init:)
			(rama_Cut_Away init:)
			(gCurRoom case: 0)
		else
			(gCurRoom case: 2)
		)
	)

	(method (dispose)
		(ClearFlag 102)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sButton1Pushed play:)
				(if (proc1111_24 102)
					(gCurRoom case: 0)
					(SetFlag 102)
					(controlButton2 init:)
					(controlButton3 init:)
					(controlButtonA init:)
					(controlButtonB init:)
					(controlButtonC init:)
					(controlButtonD init:)
					(controlButtonE init:)
					(solar_System init:)
					(rama_Wire_Frame init:)
					(rama_Cut_Away init:)
				else
					(gCurRoom case: 2)
					(ClearFlag 102)
					(controlButton2 dispose:)
					(controlButton3 dispose:)
					(controlButtonA dispose:)
					(controlButtonB dispose:)
					(controlButtonC dispose:)
					(controlButtonD dispose:)
					(controlButtonE dispose:)
					(solar_System dispose:)
					(rama_Wire_Frame dispose:)
					(rama_Cut_Away dispose:)
					(proc1111_6)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButton2 of Button
	(properties
		x 303
		y 230
		view 3107
		loop 1
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 103)
			(rama_Wire_Frame setCycle: Fwd)
		)
	)

	(method (dispose)
		(ClearFlag 103)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sButton2Pushed play:)
				(if (proc1111_24 103)
					(self cel: 0)
					(rama_Wire_Frame setCycle: Fwd)
					(if (proc1111_24 110)
						(SetFlag 110)
						(mapsUncovering play:)
					)
					(SetFlag 103)
				else
					(rama_Wire_Frame setCycle: 0)
					(ClearFlag 103)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButton3 of Button
	(properties
		x 346
		y 211
		view 3107
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 104)
			(solar_System setCycle: Fwd)
		)
	)

	(method (dispose)
		(ClearFlag 104)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sButton3Pushed play:)
				(if (proc1111_24 104)
					(solar_System setCycle: Fwd)
					(SetFlag 104)
				else
					(solar_System setCycle: 0)
					(ClearFlag 104)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButtonA of Button
	(properties
		x 243
		y 204
		view 3107
		loop 7
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 105)
			(gCurRoom setScript: schematic_1_Play)
		)
	)

	(method (dispose)
		(ClearFlag 105)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sOtherButtonsPushed play:)
				(if (proc1111_24 105)
					(SetFlag 105)
					(gCurRoom setScript: schematic_1_Play)
				else
					(ClearFlag 105)
					(schematic_1_Play dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButtonB of Button
	(properties
		x 246
		y 212
		view 3107
		loop 6
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 106)
			(gCurRoom setScript: schematic_2_Play)
		)
	)

	(method (dispose)
		(ClearFlag 106)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sOtherButtonsPushed play:)
				(if (proc1111_24 106)
					(SetFlag 106)
					(gCurRoom setScript: schematic_2_Play)
				else
					(ClearFlag 106)
					(schematic_2_Play dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButtonC of Button
	(properties
		x 243
		y 222
		view 3107
		loop 5
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 107)
			(gCurRoom setScript: schematic_3_Play)
		)
	)

	(method (dispose)
		(ClearFlag 107)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sOtherButtonsPushed play:)
				(if (proc1111_24 107)
					(SetFlag 107)
					(gCurRoom setScript: schematic_3_Play)
				else
					(ClearFlag 107)
					(schematic_3_Play dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButtonD of Button
	(properties
		x 243
		y 233
		view 3107
		loop 4
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 108)
			(gCurRoom setScript: schematic_4_Play)
		)
	)

	(method (dispose)
		(ClearFlag 108)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sOtherButtonsPushed play:)
				(if (proc1111_24 108)
					(SetFlag 108)
					(gCurRoom setScript: schematic_4_Play)
				else
					(ClearFlag 108)
					(schematic_4_Play dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance controlButtonE of Button
	(properties
		x 240
		y 244
		view 3107
		loop 3
		cel 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
		(if (IsFlag 109)
			(gCurRoom setScript: schematic_5_Play)
		)
	)

	(method (dispose)
		(ClearFlag 109)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(sOtherButtonsPushed play:)
				(if (proc1111_24 109)
					(SetFlag 109)
					(gCurRoom setScript: schematic_5_Play)
				else
					(ClearFlag 109)
					(schematic_5_Play dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rama_Cut_Away of View
	(properties
		x 19
		y 70
		view 3111
	)

	(method (init)
		(super init: global117)
		(self setPri: 9)
	)
)

(instance solar_System of Prop
	(properties
		noun 35
		x 483
		y 73
		view 3110
	)

	(method (init)
		(super init: global117)
		(self setHotspot: 144)
	)
)

(instance rama_Wire_Frame of Prop
	(properties
		x 392
		y 161
		view 3109
	)

	(method (init)
		(super init: global117)
		(self setPri: 255)
	)
)

(instance mapsUncovering of Sound
	(properties
		flags 5
		number 7501
	)
)

(instance turnDisplayOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 102)
				(controlButton1 dispose:)
				(controlButton2 dispose:)
				(controlButton3 dispose:)
				(controlButtonA dispose:)
				(controlButtonB dispose:)
				(controlButtonC dispose:)
				(controlButtonD dispose:)
				(controlButtonE dispose:)
				(solar_System dispose:)
				(rama_Wire_Frame dispose:)
				(proc1111_6)
				(rama_Cut_Away dispose:)
				(FrameOut)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance schematic_1_Play of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 3101 3 51 global161 0 250 1 self)
				(= state -1)
			)
		)
	)
)

(instance schematic_2_Play of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 3102 94 77 global161 0 250 1 self)
				(= state -1)
			)
		)
	)
)

(instance schematic_3_Play of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 3103 23 71 global161 0 250 1 self)
				(= state -1)
			)
		)
	)
)

(instance schematic_4_Play of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 3104 3 51 global161 0 250 1 self)
				(= state -1)
			)
		)
	)
)

(instance schematic_5_Play of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 3105 8 69 global161 0 250 1 self)
				(= state -1)
			)
		)
	)
)

(instance sButton1Pushed of Sound
	(properties
		flags 5
		number 3001
	)
)

(instance sButton2Pushed of Sound
	(properties
		flags 5
		number 3002
	)
)

(instance sButton3Pushed of Sound
	(properties
		flags 5
		number 3003
	)
)

(instance sOtherButtonsPushed of Sound
	(properties
		flags 5
		number 3004
	)
)

