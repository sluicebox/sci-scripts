;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm180 0
)

(local
	local0
)

(instance rm180 of GloryRm
	(properties
		picture 180
	)

	(method (init)
		(ClearFlag 6)
		(gTheIconBar disable:)
		(super init: &rest)
		(gGlory handsOff:)
		(darkOne init:)
		(gCurRoom setScript: sRise)
		(gLongSong number: 180 setLoop: 1 play:)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(SetFlag 6)
		(super dispose: &rest)
	)
)

(instance darkOne of Prop
	(properties
		x 158
		y 81
		view 180
		signal 24576
		cycleSpeed 10
	)
)

(instance sRise of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(switch local0
			(5
				(cond
					(register
						(Palette 2 0 255 (-= register 2)) ; PalIntensity
					)
					((IsFlag 316)
						(gCurRoom newRoom: 780)
					)
					(else
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 2)
				(soundFX number: 978 setLoop: -1 play:)
			)
			(1
				(if (IsFlag 316)
					(Palette 2 0 255 100) ; PalIntensity
				)
				(= seconds 3)
			)
			(2
				(PalVary 0 180 10) ; PalVaryStart
				(windFX number: 983 setLoop: -1 play:)
				(= seconds 10)
			)
			(3
				(soundFX number: 974 setLoop: 1 play:)
				(darkOne signal: (| (darkOne signal:) $0001) setCycle: End self)
			)
			(4
				(darkOne setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(soundFX number: 975 setLoop: 1 play:)
				(darkOne view: 181 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(darkOne view: 182 setCel: 0 setCycle: End self)
			)
			(7
				(darkOne view: 183 setCel: 0 setCycle: End self)
			)
			(8
				(darkOne view: 184 setCel: 0 setCycle: End self)
			)
			(9
				(darkOne view: 185 setCel: 0 setCycle: End self)
			)
			(10
				(if (== gPrevRoomNum 730)
					(EgoDead 1 180) ; "As the Shadows of Darkness cover the land, and thousands of voices cry out in agony and grief, you think to yourself, "Maybe that wasn't QUITE the right thing to do.""
					(= register 0)
					(= local0 5)
				else
					(darkOne view: 186 setLoop: 0 setCel: 0 setCycle: End self)
				)
			)
			(11
				(gLongSong fade:)
				(soundFX number: 974 play:)
				(RemapColors 0) ; Off
				(Palette 2 0 255 1500) ; PalIntensity
				(= ticks 1)
			)
			(12
				(Palette 2 0 255 100) ; PalIntensity
				(= ticks 24)
			)
			(13
				(Palette 2 0 255 1500) ; PalIntensity
				(= ticks 1)
			)
			(14
				(Palette 2 0 255 100) ; PalIntensity
				(= ticks 1)
			)
			(15
				(= register 100)
				(= local0 5)
			)
			(16
				(= local0 2)
				(soundFX number: 974 play:)
			)
			(17
				(= register 50)
				(= local0 3)
			)
			(18
				(= local0 4)
				(soundFX stop:)
				(gLongSong2 number: 974 setLoop: 1 play:)
			)
			(19
				(= register 30)
				(= local0 5)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance windFX of Sound
	(properties)
)

