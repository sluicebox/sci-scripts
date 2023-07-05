;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Str)
(use PanelPlane)
(use Timer)
(use Sound)
(use Game)
(use System)

(public
	BombTimer 0
	BombInset 1
)

(local
	local0
)

(instance tickSound of Sound
	(properties
		number 862
	)
)

(instance BombTimer of Timer
	(properties)

	(method (init)
		(super init: self)
		(= seconds 3600)
		(= local0 (Str newWith: 9))
	)

	(method (dispose)
		(gGame disposeText:)
		(local0 dispose:)
		(SetFlag 399)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2 [temp3 2])
		(if
			(and
				(not (gPanels contains: gControlPanel))
				(!= lastTime (= temp0 (GetTime 1))) ; SysTime12
			)
			(= lastTime temp0)
			(-- seconds)
			(= temp1 (/ seconds 60))
			(= temp2 (- seconds (* temp1 60)))
			(if (< temp1 0)
				(= temp1 0)
			)
			(if (< temp2 0)
				(= temp2 0)
			)
			(cond
				((< temp1 10)
					(if (< temp2 10)
						(local0 format: {00:0%d:0%d} temp1 temp2)
					else
						(local0 format: {00:0%d:%d} temp1 temp2)
					)
				)
				((< temp2 10)
					(local0 format: {00:%d:0%d} temp1 temp2)
				)
				(else
					(local0 format: {00:%d:%d} temp1 temp2)
				)
			)
			(if (gPanels contains: BombInset)
				(tickSound play:)
			)
			(gGame disposeText: makeText: (local0 data:) 200 1 998)
			(if
				(and
					(or (<= seconds 0) (> seconds 3600))
					(not (gPanels contains: gControlPanel))
					(not (gPanels contains: (ScriptID 9 2))) ; PlBagPlane
				)
				(self dispose:)
				(if (OneOf gCurRoomNum 270 820 870 880)
					(gCurRoom notify: 19)
				)
				(if global208
					(global208 dispose:)
				)
				(if (gCurRoom script:)
					((gCurRoom script:) dispose:)
				)
				(Sounds eachElementDo: #stop)
				(gInventory dispose:)
				(= gInventory ((ScriptID 9 0) new:)) ; LightInv
				(gPanels eachElementDo: #dispose)
				(DoRobot)
				(gCurRoom fade: 2 1)
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(FrameOut)
				(ClearFlag 394)
				(SetFlag 399)
				(Palette 2 0 255 100) ; PalIntensity
				(if
					(and
						(or (<= gCurRoomNum 270) (> gCurRoomNum 360))
						(not (IsFlag 407))
					)
					(SetFlag 400)
				)
				(= global224 1)
				(= global225 380)
				(gGame getDisc: global224)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance BombInset of InsetPanelPlane
	(properties
		disposeNotOnMe 1
	)

	(method (init &tmp temp0 temp1 temp2)
		((ScriptID 271 0) dispose:) ; toolBoxPanel
		(= temp2 (gPanels size:))
		(for ((= temp1 0)) (< temp1 temp2) ((++ temp1))
			(if
				(and
					(!= (gPanels at: temp1) (ScriptID 9 1)) ; PlInterface
					(gPanels contains: (gPanels at: temp1))
				)
				((gPanels at: temp1) dispose:)
			)
		)
		(super init: 0 0 200 200)
		(cond
			((IsFlag 393)
				(= temp0 2)
			)
			((IsFlag 392)
				(= temp0 1)
			)
			(else
				(= temp0 0)
			)
		)
		(self setBitmap: 2084 temp0 0)
		(if (IsFlag 394)
			(bombClockFace init: self 1 1)
		)
		(if (or (not (IsFlag 393)) (not (IsFlag 392)))
			(bombFeat init: self 1 1)
		)
	)

	(method (dispose)
		(if (IsFlag 394)
			(bombClockFace dispose:)
		)
		(super dispose:)
	)
)

(instance bombFeat of PanelFeature
	(properties
		nsBottom 190
		nsLeft 51
		nsRight 150
		nsTop 71
	)

	(method (doVerb theVerb)
		(switch theVerb
			(78 ; invAlarmClock
				(if (IsFlag 392)
					(BombInset setBitmap: 2084 2 0)
					(SetFlag 393)
					(gInventory deleteItem: (ScriptID 9 69)) ; invAlarmClock
					(SetFlag 394)
					(bombClockFace init: BombInset 1 1)
					(BombInset dispose:)
					(FrameOut)
					(BombTimer init:)
				)
			)
			(65 ; invCircuitBoard
				(BombInset setBitmap: 2084 1 0)
				(SetFlag 392)
				(gInventory deleteItem: (ScriptID 9 56)) ; invCircuitBoard
			)
		)
	)
)

(instance bombClockFace of PanelProp
	(properties
		loop 4
		view 2084
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(self doit:)
	)

	(method (doit)
		(= cel (- 29 (/ (BombTimer seconds:) 120)))
		(super doit:)
	)
)

