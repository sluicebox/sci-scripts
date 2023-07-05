;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 329)
(include sci.sh)
(use Main)
(use SQRoom)
(use MCyc)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm329 0
)

(local
	[local0 21] = [0 0 164 122 0 1 166 120 0 2 168 118 0 0 170 116 0 1 172 114 -32768]
	[local21 21] = [1 0 161 125 1 1 163 123 1 2 165 121 1 3 167 119 1 4 169 117 -32768]
)

(instance rm329 of SQRoom
	(properties)

	(method (init)
		(Load rsPIC 803)
		(UnLoad 129 803)
		(rm329 picture: 329)
		(Load rsVIEW 330)
		(LoadMany rsSOUND 127 128)
		(gLongSong fade: 0 2 1 1)
		(gLongSong2 number: 127 vol: 1 loop: -1 play: fade: 127 1 1 0)
		(HandsOff)
		(super init:)
		(proc0_14 {Space Quest X} global146)
		(self setScript: rmScript)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sub init: setCycle: Fwd setMotion: MoveTo 164 122 self)
			)
			(1
				(sub setCycle: MCyc @local0)
				(gLongSong2 number: 128 vol: 127 hold: 1 play:)
				(subTop init: setCycle: MCyc @local21 self)
			)
			(2
				(sub setCycle: Fwd setMotion: MoveTo 345 114)
				(subTop setMotion: MoveTo 345 117 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(DrawPic 803 41)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance sub of Actor
	(properties
		x 11
		y 126
		description {submarine}
		yStep 1
		view 330
		priority 2
		signal 18432
		xStep 2
	)
)

(instance subTop of Actor
	(properties
		x -25
		y 117
		description {submarine}
		yStep 1
		view 330
		loop 1
		cel 4
		priority 10
		signal 22544
		xStep 2
	)
)

