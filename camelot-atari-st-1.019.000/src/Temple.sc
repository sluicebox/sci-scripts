;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 135)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Temple 0
)

(instance Temple of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 95)
		(Load rsSCRIPT 199)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (gEgo edgeHit:) (not (gEgo script:)))
			(gEgo setScript: (ScriptID 199 1)) ; cantLeave
		)
		(if (IsFlag 221)
			(ClearFlag 221)
			(if (not (IsFlag 222))
				(HandsOn)
			)
			(DisposeScript 199)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<!*][/room,temple,ruin]')
							(Said '//room,temple,ruin')
							(Said 'look<around')
						)
						(cond
							((or (== gCurRoomNum 75) (== gCurRoomNum 76))
								(Print 135 0) ; "In this section of the temple there are four broken and fallen pillars."
							)
							((== gCurRoomNum 77)
								(Print 135 1) ; "In this section of the Temple there are three broken pillars and an indentation where a fourth pillar once stood."
							)
							((== gCurRoomNum 78)
								(Print 135 2) ; "These steps must be the only remnant of the original door to the Temple. At the threshold there is a lunar spiral engraved in the marble."
								(Print 135 3) ; "There are also three broken pillars and an indentation where a fourth pillar once stood."
							)
						)
					)
					((Said '<below,below/column')
						(Print 135 4) ; "An interesting idea, if one can find a way to do so."
					)
					((Said '<above/wall')
						(Print 135 5) ; "You cannot see beyond the walls surrounding the Temple except for a glimpse of tree tops and tiled roofs in the distance."
					)
					((Said '<up')
						(Print 135 6) ; "No part of the Temple's roof remains. Only the sky arches overhead."
					)
					((Said '<down')
						(Print 135 7) ; "The floor of the Temple is made of marble, weathered from the ages and invaded by weeds."
					)
					((or (Said '/base') (Said '//base'))
						(Print 135 8) ; "The round pedestal in the center of the temple's ruins must have once held an altar or statue, but is empty now."
					)
					(
						(or
							(Said '/aphrodite,goddess')
							(Said '//aphrodite,goddess')
						)
						(if (IsFlag 208)
							(Print 135 9) ; "You will never see her again."
						else
							(Print 135 10) ; "She will reveal herself to you only when she is ready."
						)
					)
					((or (Said '/column,base') (Said '//column,base'))
						(if (IsFlag 208)
							(Print 135 11) ; "Each broken pillar looks much the same as its neighbor. You must find the right one by your wits."
						else
							(Print 135 12) ; "The elegant marble pillars which once held a roof have all been broken and thrown down, the work of those who would destroy the worship of Aphrodite."
						)
					)
					((or (Said '/plant,weed') (Said '//plant,weed'))
						(Print 135 13) ; "They are common weeds, of no interest."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 135 14) ; "The walls which encompass these ruins have deliberately been build without windows or doors, to enclose and hide this ruin."
					)
					(
						(or
							(Said '/stair,entrance,exit')
							(Said '//stair,entrance,exit')
						)
						(Print 135 15) ; "This part of the Temple of Aphrodite is surrounded by high walls without doors or windows. There is no way out from this direction."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'move,press,topple/column')
				(cond
					(global194
						(Print 135 16) ; "By all that is sacred, King Arthur, go where the dove leads you and forget all else!"
					)
					(
						(and
							(not (IsFlag 207))
							(IsFlag 214)
							(IsFlag 215)
							(IsFlag 213)
						)
						(Print 135 17) ; "Arthur, pay attention! A powerful foe awaits you. This is no time to play at being Sampson."
					)
					(else
						(gEgo setScript: (ScriptID 199 0)) ; pushPillars
					)
				)
			)
			((Said 'move,press,topple,base')
				(Print 135 18) ; "The pedestal is immovable."
			)
			((Said 'walk,stair,climb,get,search/base')
				(Print 135 19) ; "I sense that the power of the Goddess keeps you from treading there, where once her holy of holies must have been kept."
			)
			((Said 'get,pick/plant,weed')
				(Print 135 13) ; "They are common weeds, of no interest."
			)
			((Said 'lift,lift,get/column')
				(Print 135 20) ; "That is beyond your strength."
			)
		)
	)
)

