;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2485)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm2485 0
)

(instance rm2485 of KQRoom
	(properties
		picture 2485
	)

	(method (init)
		(super init:)
		(SetFlag 55)
		(ClearFlag 359)
		(gEgo
			view: 2485
			posn: 154 135
			init:
			loop: 0
			cel: 0
			setPri: 180
			setScale: 0
		)
		(self setScript: zapScript)
	)
)

(instance zapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 843) ; WAVE
				(Load 140 816) ; WAVE
				(Load rsVIEW 2485)
				(gEgo setCycle: End self)
			)
			(1
				(mal init: setCycle: End self)
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(2
				(gKqSound1 number: 843 setLoop: 1 play: self)
				(zap init: setPri: 190 setCycle: End self)
			)
			(3 0)
			(4
				(gCurRoom newRoom: 2100)
			)
		)
	)
)

(instance mal of Prop
	(properties
		x 162
		y 141
		view 2485
		loop 1
	)
)

(instance zap of Prop
	(properties
		x 162
		y 143
		view 2485
		loop 2
	)
)

