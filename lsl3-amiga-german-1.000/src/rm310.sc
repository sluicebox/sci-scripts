;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use AutoDoor)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	[local0 2]
)

(instance rm310 of Rm
	(properties
		picture 310
		south 220
	)

	(method (init)
		(super init:)
		(gAddToPics add: atpSign doit:)
		(if (< gLawyerState 8)
			(gAddToPics add: atpRoger doit:)
		else
			(gAddToPics add: atpNoRoger doit:)
		)
		(aDoor init:)
		(self setScript: RoomScript)
		(if (== gPrevRoomNum 320)
			(gEgo posn: 220 88)
		else
			(gEgo posn: 84 188)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look<down')
				(Print 310 0) ; "When you lean over the railing you can see straight down."
			)
			(
				(and
					(gEgo has: 2) ; Ginsu_Knife
					(!= ((gInventory at: 2) view:) 21) ; Ginsu_Knife
					(Said 'sharpen/ginsu')
				)
				(Print 310 1) ; "This area is ALMOST suitable, but the textured concrete here is just too rough for your delicate ginsu."
			)
			((Said 'look,look>')
				(cond
					((Said '/camp,beach,bay,water')
						(Print 310 2) ; "Those lawyers really know how to pick a location!"
					)
					((Said '/awning')
						(Print 310 3) ; "You surmise those three large initials comprise this firm's logo."
					)
					((Said '/plant,bush')
						(Print 310 4) ; "There are a few beautiful flowers clinging tenaciously to a steep escarpment."
					)
					((Said '/flower,boulder,wall')
						(Print 310 5) ; "There are some beautiful flowers here."
					)
					((Said '[/area]')
						(Print 310 6) ; "You are outside the legal offices of Dewey, Cheatem & Howe, the best Corporation of Associated Legal Professionals on the island of Nontoonyt!"
						(Print 310 7 #at -1 144) ; "(Also the ONLY!)"
					)
				)
			)
			((Said 'get,get/plant,bush')
				(Print 310 8) ; "The only plants here that catch your eye are those hanging on that sheer rock cliff."
			)
			((Said 'get,get,pick/flower')
				(Print 310 9) ; "While these flowers are beautiful, they just don't "lei" right!"
			)
		)
	)
)

(instance atpSign of PicView
	(properties
		x 192
		y 189
		view 310
		priority 14
	)
)

(instance aDoor of AutoDoor
	(properties
		x 220
		y 87
		view 310
		loop 1
		cycleSpeed 2
		entranceTo 320
	)

	(method (init)
		(super init:)
		(self setPri: 4)
	)
)

(instance atpRoger of PicView
	(properties
		x 219
		y 45
		view 310
		loop 2
		priority 2
	)
)

(instance atpNoRoger of PicView
	(properties
		x 219
		y 51
		view 310
		loop 2
		cel 1
		priority 2
	)
)

