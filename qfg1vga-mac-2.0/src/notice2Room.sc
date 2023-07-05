;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use GameControls)
(use Game)
(use User)
(use System)

(public
	notice2Room 0
)

(local
	[local0 6] = [14 68 120 138 140 141]
	local6
)

(instance notice2Room of Rm
	(properties
		picture 100
		style 1
	)

	(method (init)
		(super init: &rest)
		(ClearFlag 359)
		(Load rsVIEW 100)
		(self setScript: startThisRoom)
	)

	(method (dispose &tmp temp0)
		(startControls eachElementDo: #dispose dispose: release:)
		(User canControl: 1)
		(super dispose:)
	)
)

(instance startThisRoom of Script
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(= cycles 2)
			)
			(1
				(gTheIconBar enable:)
				(startControls init: show:)
				(self dispose:)
			)
		)
	)
)

(instance startControls of GameControls
	(properties)

	(method (init &tmp temp0)
		(self
			add:
				(paper1 theObj: introCode selector: #doit yourself:)
				(paper2 theObj: charCode selector: #doit yourself:)
				(paper3 theObj: restoreCode selector: #doit yourself:)
		)
		(super init: &rest)
	)

	(method (show)
		(|= state $0020)
		(self eachElementDo: #show)
		((= curIcon (= highlightedIcon (self at: 0))) highlight: 1)
		(DrawCel 100 4 0 166 22 15)
		(DrawCel 100 4 1 150 75 15)
		(DrawCel 100 4 2 152 128 15)
		(Platform 0 4 3 -1)
		(gGame setCursor: 999 1)
		(self doit: hide:)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if local6
			(gCurRoom newRoom: local6)
			(event dispose:)
			(return 1)
		)
		(= temp0 (event x:))
		(= temp1 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp4 0)
		(= temp5 (event modifiers:))
		(= temp6 (self firstTrue: #onMe event))
		(event dispose:)
		(cond
			((& temp2 $0040) ; direction
				(switch temp3
					(JOY_RIGHT
						(self advance:)
					)
					(JOY_LEFT
						(self retreat:)
					)
					(JOY_UP
						(self retreat:)
					)
					(JOY_DOWN
						(self advance:)
					)
				)
			)
			((== temp2 evNULL)
				(cond
					((not (IsObject temp6))
						(if (IsObject highlightedIcon)
							(highlightedIcon highlight: 0)
							(= highlightedIcon 0)
						)
					)
					((and temp6 (!= temp6 highlightedIcon))
						(= oldMouseY 0)
						(self highlight: temp6)
					)
				)
			)
			((not (IsObject highlightedIcon)) 0)
			((== temp2 evMOUSEBUTTON)
				(switch highlightedIcon
					(paper1
						(introCode doit:)
					)
					(paper2
						(charCode doit:)
					)
					(paper3
						(restoreCode doit:)
					)
				)
			)
			((== temp2 evKEYBOARD)
				(switch temp3
					(KEY_ESCAPE
						(introCode doit:)
					)
					(KEY_RETURN
						(switch highlightedIcon
							(paper1
								(introCode doit:)
							)
							(paper2
								(charCode doit:)
							)
							(paper3
								(restoreCode doit:)
							)
						)
					)
					(KEY_TAB
						(self advance:)
					)
				)
			)
		)
		(return temp4)
	)
)

(instance paper1 of ControlIcon
	(properties
		view 100
		loop 2
		cel 0
		nsLeft 139
		nsTop 14
	)

	(method (highlight param1)
		(if param1
			(DrawCel 100 2 1 nsLeft nsTop 15)
		else
			(DrawCel 100 2 2 nsLeft nsTop 15)
		)
	)
)

(instance paper2 of ControlIcon
	(properties
		view 100
		loop 2
		cel 0
		nsLeft 140
		nsTop 68
	)

	(method (highlight param1)
		(if param1
			(DrawCel 100 2 1 nsLeft nsTop 15)
		else
			(DrawCel 100 2 2 nsLeft nsTop 15)
		)
	)
)

(instance paper3 of ControlIcon
	(properties
		view 100
		loop 2
		cel 0
		nsLeft 141
		nsTop 120
	)

	(method (highlight param1)
		(if param1
			(DrawCel 100 2 1 nsLeft nsTop 15)
		else
			(DrawCel 100 2 2 nsLeft nsTop 15)
		)
	)
)

(instance introCode of Code
	(properties)

	(method (doit)
		(= local6 200)
		(gCurRoom newRoom: 200) ; intro
	)
)

(instance charCode of Code
	(properties)

	(method (doit)
		(= local6 202)
		(gCurRoom newRoom: 202) ; selChar
	)
)

(instance restoreCode of Code
	(properties)

	(method (doit)
		(gGame restore:)
		(DrawCel 100 4 2 152 128 15)
	)
)

