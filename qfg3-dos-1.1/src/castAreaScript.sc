;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	castAreaScript 0
)

(local
	local0
	local1
	[local2 8] = [2 3 0 3 0 1 2 3]
	[local10 8] = [0 0 0 1 0 0 2 3]
)

(instance castAreaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (gEgo loop:))
				(gLongSong2 number: 900 setLoop: 1 play:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local1 (gEgo cel:))
					(gEgo
						setMotion: 0
						view: 19
						loop: [local10 local0]
						setCycle: End self
					)
				else
					(gEgo
						setMotion: 0
						view: 15
						loop: [local2 local0]
						setCycle: End self
					)
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 20 loop: local0 cel: local1)
				else
					(gEgo normalize: local0)
				)
				(switch register
					(78
						(Palette palSET_INTENSITY 0 255 500)
						(Palette palSET_INTENSITY 0 255 100)
					)
					(76
						(if
							(not
								(OneOf
									gCurRoomNum
									230
									280
									310
									390
									430
									650
									770
									780
									810
									853
								)
							)
							(gMessager say: 0 0 1 1 0 12) ; "You sense no magic in this area."
						else
							((ScriptID gCurRoomNum 0) doVerb: -76)
						)
					)
					(77
						(if
							(not
								(OneOf
									gCurRoomNum
									230
									280
									310
									400
									430
									650
									700
									850
									851
									852
									853
									854
								)
							)
							(gMessager say: 0 0 2 1 0 12) ; "Nothing seems to have been triggered."
						else
							((ScriptID gCurRoomNum 0) doVerb: -77)
						)
					)
					(80
						(if
							(not
								(OneOf
									gCurRoomNum
									230
									280
									310
									390
									400
									430
									450
									630
									650
									700
									820
									850
									851
									852
									853
									854
								)
							)
							(gMessager say: 0 0 4 1 0 12) ; "A feeling of peace and tranquility fills the area."
						else
							((ScriptID gCurRoomNum 0) doVerb: -80)
						)
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

