;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Scaler)
(use Actor)
(use System)

(public
	endgame 0
)

(local
	local0
)

(instance endgame of PQRoom
	(properties
		noun 1
		picture 99
		style -32758
		vanishingY 1
	)

	(method (init)
		(super init: &rest)
		(HandsOff)
		(= gNormalCursor 601)
		(= global250 999)
		(gGame setCursor: 601 1)
		(gTheIconBar hide: disable:)
		(Palette palSET_FROM_RESOURCE 999 2)
		(self setScript: deadScript)
	)
)

(instance deadScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gLongSong number: 804 loop: 1 play:)
				(skull setScale: SpeedScaler self init:)
			)
			(1
				(gTheIconBar enable:)
				(= gNormalCursor 999)
				(gGame setCursor: 999 1)
				(= cycles 2)
			)
			(2
				(if (== global212 3)
					(= local0 30)
				else
					(= local0 70)
				)
				(gLongSong2 number: 825 loop: 1 play:)
				(while
					(==
						1
						(= register
							(Print
								y: 90
								mode: 1
								addText: 1 0 global212 0 0 0 200
								addButton: 1 1 0 4 0 10 local0 200 ; "Restore"
								addButton: 2 1 0 39 0 70 local0 200 ; "Restart"
								addButton: 3 1 0 5 0 135 local0 200 ; "Quit"
								init:
							)
						)
					)
					(gGame restore: setCursor: 999 1)
				)
				(skull setScale: SpeedScaler self -2)
			)
			(3
				(switch register
					(2
						(gGame restart: 1)
					)
					(3
						(= gQuit 1)
					)
				)
			)
		)
	)
)

(instance skull of Actor
	(properties
		x 150
		y 40
		view 666
		priority 15
		signal 16400
		scaleX 0
		scaleY 0
		cycleSpeed 2
	)
)

(class SpeedScaler of Scaler
	(properties
		cycleCnt 0
		caller 0
		dir 1
	)

	(method (cue)
		(if caller
			(caller cue:)
		)
		(self dispose:)
	)

	(method (dispose)
		(client scaler: 0)
		(super dispose: &rest)
	)

	(method (init param1 param2 param3)
		(= client param1)
		(= cycleCnt (- (- gGameTime (client cycleSpeed:)) 1))
		(if argc
			(= caller param2)
			(if (> argc 1)
				(= dir param3)
			else
				(= dir 1)
			)
		)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(client
				scaleX: (+ (client scaleX:) dir)
				scaleY: (+ (client scaleY:) dir)
			)
			(= cycleCnt gGameTime)
			(cond
				((< dir 1)
					(if (<= (client scaleX:) 0)
						(self cue:)
					)
				)
				((>= (client scaleX:) 128)
					(self cue:)
				)
			)
		)
	)
)

