;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use LoadMany)
(use Extra)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	titleScreen 0
	showTitle 1
)

(local
	local0
	[local1 10]
	[local11 8] = [61 160 264 130 208 169 184 97]
	[local19 8] = [29 70 32 20 54 140 21 59]
	[local27 8] = [1 3 0 2 1 0 2 1]
)

(procedure (localproc_0)
	(for ((= local0 0)) (< local0 8) ((++ local0))
		((= [local1 local0] (Clone Extra))
			view: 950
			setLoop: 0
			cel: 5
			posn: [local11 local0] [local19 local0]
			cycleSpeed: [local27 local0]
			cycleType: 2
			pauseCel: 5
			hesitation: (Random 0 10)
			ignoreActors:
			isExtra: 1
			init:
		)
	)
)

(instance titleScreen of Rm
	(properties
		picture 902
		style 7
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(HandsOff)
		(= global107 1)
		(Load rsSOUND 1)
		(LoadMany rsVIEW 913 950)
		(Load rsSCRIPT 87)
		(super init:)
		(MenuBar hide: state: 0)
		((ScriptID 0 23) number: 1 loop: 1 play:) ; backSound
		(if (!= global101 0)
			(localproc_0)
		)
		(if (!= gPrevRoomNum 777) ; speedChecker
			(showTitle start: 2)
			(self setScript: showTitle)
		else
			(QUEST init:)
			(FOR init:)
			(CROWN init:)
			(copyright init:)
			(self setScript: showTitle)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if (== (event type:) evMOUSEBUTTON)
			(if (showTitle seconds:)
				(showTitle cue:)
			else
				(event claimed: 1)
			)
		)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_RETURN
					(if (showTitle seconds:)
						(showTitle cue:)
					else
						(event claimed: 1)
					)
				)
				(KEY_F2
					(MenuBar state: 1 handleEvent: event state: 0)
				)
				(else
					(event claimed: 1)
				)
			)
		)
	)
)

(instance showTitle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (if (>= global101 1) 10 else 5))
			)
			(1
				(= seconds 0)
				(QUEST dispose:)
				(FOR dispose:)
				(CROWN dispose:)
				(copyright dispose:)
				(= cycles 1)
			)
			(2
				(= global107 0)
				(if (!= global101 0)
					([local1 5] hide:)
				)
				(self setScript: (ScriptID 87 0)) ; TitleButton
			)
			(3
				(if (!= global101 0)
					(for ((= local0 0)) (< local0 8) ((++ local0))
						([local1 local0] dispose:)
					)
				)
				((ScriptID 0 23) fade:) ; backSound
				(= cycles 2)
			)
			(4
				((ScriptID 87 0) changeState: 3) ; TitleButton
			)
		)
	)
)

(instance QUEST of View
	(properties
		x 67
		y 167
		view 913
	)
)

(instance FOR of View
	(properties
		x 133
		y 169
		view 913
		cel 1
	)
)

(instance CROWN of View
	(properties
		x 226
		y 164
		view 913
		cel 2
	)
)

(instance copyright of View
	(properties
		x 164
		y 181
		view 913
		loop 1
	)
)

