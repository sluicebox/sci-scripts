;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rm200 0
)

(local
	local0
	local1
	[local2 20]
)

(instance rm200 of Rm
	(properties
		picture 200
		horizon 66
		picAngle 15
	)

	(method (init)
		(if (!= (gLongSong signal:) -1)
			(gLongSong client: gCurRoom fade: 0 1 10 1)
		else
			(self cue:)
		)
		(ClearFlag 6)
		(if (= global449 (PalVary pvGET_CURRENT_STEP))
			(PalVary pvPAUSE_RESUME 1)
		)
		(switch gPrevRoomNum
			(150
				(= style -32759)
			)
			(210
				(= style -32761)
			)
			(420
				(= style -32759)
				(self cue:)
			)
			(620
				(= style -32759)
				(self cue:)
			)
			(else
				(= style -32759)
				(if (OneOf gPrevRoomNum 110 120 100) ; openCart
					(self cue:)
				)
			)
		)
		(super init:)
		(self setScript: showTarnaFarShot)
	)

	(method (cue)
		(gLongSong number: 911 setLoop: 1 play: showTarnaFarShot)
	)

	(method (dispose)
		(if global449
			(PalVary pvPAUSE_RESUME 0)
		)
		(SetFlag 6)
		(super dispose:)
	)
)

(instance showTarnaFarShot of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(SetCursor 0)
				(= cycles 2)
			)
			(1
				(DrawCel 200 0 0 125 171 15)
				(Message msgGET 200 0 0 1 1 @local2) ; "Tarna"
				(Display @local2 dsCOORD 140 173 dsALIGN alCENTER dsCOLOR 0 dsFONT 123)
				(Display @local2 dsCOORD 139 172 dsALIGN alCENTER dsCOLOR 29 dsFONT 123)
				(switch gPrevRoomNum
					(120
						(= local0 280)
					)
					(150
						(= local0 210)
					)
					(420
						(= local0 210)
					)
					(620
						(= local0 210)
					)
					(else
						(= local0 210)
					)
				)
			)
			(2
				(gTheIconBar enable:)
				(SetCursor 1)
				(gCurRoom newRoom: local0)
			)
		)
	)
)

