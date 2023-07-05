;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3000)
(include sci.sh)
(use Main)
(use PQRoom)
(use swatInvInit)
(use Motion)
(use Actor)
(use System)

(public
	s2_3000 0
)

(instance s2_3000 of PQRoom
	(properties
		picture 3000
	)

	(method (init)
		(Load rsVIEW 30200)
		(Load rsVIEW 30201)
		(SetFlag 12)
		(super init: &rest)
		(if (IsFlag 76)
			(ClearFlag 76)
			(self setScript: consecutiveScript)
		else
			((ScriptID 4054 0) changeMusic: 29803) ; kiplandRegion
			(swatTeam init:)
			(self setScript: setupPlot)
		)
	)
)

(instance consecutiveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				((gSwatInterface curSwatButn:) doVerb:)
				(gMessager say: 0 0 1 0 self 2980) ; "Officer down. 612 Haley, Central Area. Code 3."
			)
			(2
				(SetFlag 232)
				((ScriptID 4054 0) doVerb: 181) ; kiplandRegion
			)
		)
	)
)

(instance setupPlot of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(swatTeam setCycle: CT 29 1 self)
				(= cycles 10)
			)
			(1
				(= temp0 (proc19_3 21))
				(= temp1 ((temp0 data:) reloadSnd:))
				((temp0 data:) reloadSnd: 0)
				(temp0 doVerb: 19)
				((temp0 data:) reloadSnd: temp1)
			)
			(2
				(= temp0 (proc19_3 21))
				(temp0 doVerb: 29)
				(gMessager sayRange: 0 0 3 1 2) ; "Entry team, side 1/2."
				(gSwatInterface showHandAni: 4)
				(swatTeam setCycle: CT 89 1 self)
			)
			(3
				(if (not (gTalkers isEmpty:))
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(swatTeam setCycle: CT 139 1 self)
			)
			(5
				(gMessager say: 0 0 3 3 self) ; "Roger that. Ready... Go!"
			)
			(6
				(swatTeam setCycle: End self)
			)
			(7
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance swatTeam of Prop
	(properties
		x 30
		y 266
		view 30000
	)
)

