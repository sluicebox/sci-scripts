;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3270)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Motion)
(use Actor)
(use System)

(public
	s2_3270 0
)

(instance s2_3270 of PQRoom
	(properties
		picture 3270
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(robotFeat init:)
		(cond
			((< (global112 curColIdx:) 24)
				(self setScript: sElementApproaching)
			)
			((< (global112 curColIdx:) 25)
				(self setScript: sElementNotPresent)
			)
			(else
				(self setScript: sMidFight)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sElementNotPresent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rheaWix cel: 57 setPri: 250 init:)
				(= cycles 10)
			)
			(1
				(gMessager say: 0 0 1 0 self) ; "Hold!"
				(rheaWix setCycle: CT 62 1)
			)
			(2
				(if (rheaWix cycler:)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gFxSound number: 2991 loop: 0 play:)
				(rheaWix cel: 63 setCycle: End self)
			)
			(4
				(gCurRoom newRoom: 3290) ; s2_3290
			)
		)
	)
)

(instance sElementApproaching of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rheaWix cel: 57 setPri: 250 init:)
				(rheaWix setCycle: CT 62 1)
				(proc4_6 32701 263 121 0 0 -1 1)
			)
			(1
				(gSwatInterface showHandAni: 4)
			)
			(2
				(gSwatInterface showHandAni: 3)
			)
			(3
				(self setScript: elemApproachAssoc)
			)
			(4
				(gAutoRobot pause: 1)
				(while (< (global112 curColIdx:) 25)
					(global112 endColumn:)
				)
				(gCurRoom newRoom: 3290) ; s2_3290
			)
		)
	)
)

(instance elemApproachAssoc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gFxSound number: 2992 loop: 1 play: self)
				(rheaWix setCycle: End)
			)
			(1
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sMidFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rheaWix cel: 57 setPri: 250 init: setCycle: CT 62 1 self)
			)
			(1
				(rheaWix setCycle: End)
				(gFxSound number: 2992 loop: 0 play: self)
			)
			(2
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance sOfficerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9012 -1 -1 self 1)
			)
			(1
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance rheaWix of Prop
	(properties
		x -4
		y 200
		view 32700
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance element of Prop ; UNUSED
	(properties
		view 32701
	)
)

(instance westE of HotSpot ; UNUSED
	(properties
		nsRight 20
		nsBottom 150
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3250) ; s2_3250
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

