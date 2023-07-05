;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room81 0
)

(local
	local0
)

(instance door of Actor
	(properties)
)

(instance guard of Actor
	(properties)
)

(instance guard2 of Actor
	(properties)
)

(instance guard3 of Actor
	(properties)
)

(instance guard4 of Actor
	(properties)
)

(instance Room81 of Rm
	(properties
		picture 81
	)

	(method (init)
		(super init:)
		(door view: 135 setLoop: 0 setCel: 0 posn: 266 116 setPri: 4 init:)
		(guard view: 135 loop: 2 cel: 0 posn: 254 117 setPri: 3 init:)
		(if global129
			(guard4 view: 135 setPri: 8 setLoop: 2 posn: 297 121 init: stopUpd:)
			(guard view: 135 setPri: 8 setLoop: 2 posn: 238 122 stopUpd:)
			(door view: 777)
			(gCurRoom setScript: Actions)
			(Actions state: 7)
			(Actions seconds: 12)
		else
			(gCurRoom setScript: Actions)
		)
		(gLongSong priority: 127 number: 86 loop: -1 playBed:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (== global105 1) (== global120 1))
			(-- global121)
		)
		(if (and (== global105 1) (== global120 1) (<= global121 0))
			(gCurRoom drawPic: 81 8)
			(Print 81 0) ; "The invisibility belt is now completely out of power."
			(= global105 0)
			(= global120 2)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look,look>')
					(cond
						((Said '[<around,at,in][/area]')
							(PrintSplit 81 1) ; "You are hiding behind some of the strange local vegetation looking out on a clearing and an entrance to a large underground complex. From the logo on the entrance, you deduce that this must be the infamous ScumSoft headquarters."
						)
						((Said '/guard,man,flunky')
							(Print 81 2) ; "They are heavily armed and they do not look friendly."
						)
						((Said '/complex,scum,scumsoft,soft')
							(Print 81 3) ; "You see the ScumSoft entrance in the distance."
						)
						((Said '/door,entrance')
							(if (< (door y:) 142)
								(Print 81 4) ; "The ScumSoft door is in the process of opening."
							else
								(Print 81 5) ; "The ScumSoft door is wide open, but there are two guards standing outside it."
							)
						)
					)
				)
				(
					(or
						(Said 'turn<on/belt')
						(Said 'switch<on/belt')
						(Said 'activate/belt')
						(Said 'use/belt')
						(Said 'press/button,button')
					)
					(cond
						((not (gEgo has: 16)) ; Invisibility_Belt
							(Print 81 6) ; "You don't have one."
						)
						((!= global126 1)
							(Print 81 7) ; "First you need to wear it."
						)
						((== global120 2)
							(Print 81 8) ; "The belt is now completely out of power."
						)
						((== global120 1)
							(Print 81 9) ; "It's already on."
						)
						(else
							(= global105 1)
							(= global120 1)
							(gCurRoom drawPic: 82 8)
							(RedrawCast)
							(Print 81 10) ; ""WOW! This thing really works." You then quickly realize that you only have a few moments before the belts power pack is depleted."
							(= global121 350)
						)
					)
				)
				((or (Said 'turn<off/belt') (Said 'deactivate/belt'))
					(cond
						((not (gEgo has: 16)) ; Invisibility_Belt
							(DontHave) ; "You don't have it."
						)
						((not global126)
							(Print 81 11) ; "You're not wearing it."
						)
						((!= global105 1)
							(Print 81 12) ; "It's not on."
						)
						(else
							(Print 81 13) ; "OK"
							(= global105 0)
							(= global120 0)
							(gCurRoom drawPic: 81 8)
						)
					)
				)
				(
					(or
						(Said 'enter/scum,soft,scumsoft,complex,building')
						(Said 'go<in/scum,soft,scumsoft,complex,building')
						(Said 'go<to/scum,soft,scumsoft,complex,building')
						(Said 'enter/door')
					)
					(gCurRoom newRoom: 85)
				)
				((Said 'disembark,disembark,disembark,disembark/')
					(gGame setCursor: gNormalCursor 1)
					(switch
						(= local0
							(Print ; "Where to Buddy?"
								81
								14
								#button
								{Ship}
								1
								#button
								{ScumSoft}
								2
							)
						)
						(1
							(gCurRoom newRoom: 80)
						)
						(2
							(gCurRoom newRoom: 85)
						)
					)
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(PrintSplit 81 15) ; "You make your way through the forest of strange trees to this clearing where you discover the entrance to some large underground complex. This must be ScumSoft. Suddenly the door to the complex begins to open."
				(= global129 1)
				(door
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 266 142 self
				)
			)
			(2
				(guard
					setLoop: 1
					setCycle: Walk
					setStep: 2 2
					setPri: 8
					setMotion: MoveTo 238 122 self
				)
			)
			(3
				(guard setLoop: 2)
				(guard2
					view: 135
					setLoop: 4
					setPri: 3
					posn: 249 133
					setCycle: Walk
					ignoreActors:
					setMotion: MoveTo 269 117 self
					init:
				)
			)
			(4
				(guard3
					view: 135
					setLoop: 4
					setCycle: Walk
					setPri: 3
					posn: 249 133
					setStep: 2 2
					setMotion: MoveTo 269 117 self
					init:
				)
				(guard2 setPri: 8 setPri: 9 setMotion: MoveTo 323 150)
			)
			(5
				(guard4
					view: 135
					setLoop: 4
					setCycle: Walk
					setPri: 3
					posn: 249 133
					setStep: 2 2
					setMotion: MoveTo 269 117 self
					init:
				)
				(guard3 setPri: 8 setMotion: MoveTo 323 150)
			)
			(6
				(guard4 setPri: 8 setMotion: MoveTo 297 121 self)
			)
			(7
				(guard4 setLoop: 2)
				(RedrawCast)
				(Print 81 16) ; "Several guards file out of the entrance and disperse into the woods. They must have been alerted to your presence when you landed. Two guards remain behind to watch the entrance."
				(= seconds 12)
			)
			(8
				(gGame setCursor: gNormalCursor 1)
				(switch
					(= local0
						(Print ; "Decision Time. Do you wish to:"
							81
							17
							#button
							{Stay Here}
							1
							#button
							{Return to Ship}
							2
							#button
							{Enter ScumSoft}
							3
						)
					)
					(1
						(= seconds 20)
						(-- state)
					)
					(2
						(gCurRoom newRoom: 80)
					)
					(3
						(gCurRoom newRoom: 85)
					)
					(else
						(= seconds 20)
						(-- state)
					)
				)
			)
		)
	)
)

