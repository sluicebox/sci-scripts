;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm21 0
)

(synonyms
	(doug man)
)

(local
	local0
	local1
)

(instance Rm21 of eRoom
	(properties
		picture 21
	)

	(method (dispose)
		(DisposeScript 132)
		(DisposeScript 111)
		(DisposeScript 972)
		(DisposeScript 917)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(18 2)
					(19 3)
					(20 4)
					(22 5)
					(else 8)
				)
		)
		(super init:)
		(self setRegions: 104) ; glastonburyTor
		(if (and (== global201 gCurRoomNum) (not (IsFlag 48)) (not (IsFlag 49)))
			((gTObj tWindow:) brLeft: 50 brRight: 250 brBottom: 290)
			(if (or (== gPrevRoomNum 20) (== gPrevRoomNum 18))
				(gMadMonk posn: 30 105)
				(= local1 1)
			else
				((gTObj tWindow:) brLeft: 12)
				(gMadMonk posn: 149 98)
				(= local1 2)
			)
		)
		(switch gPrevRoomNum
			(18
				(cond
					((IsFlag 53)
						(ClearFlag 53)
						(self enterRoom: 320 77 290 77)
					)
					((IsFlag 55)
						(ClearFlag 55)
						(self enterRoom: 320 205 288 170)
					)
					(else
						(self enterRoom: 320 120 290 120)
					)
				)
			)
			(19
				(cond
					((IsFlag 54)
						(ClearFlag 54)
						(gEgo setPri: 1)
						(self enterRoom: -10 60 25 60)
					)
					((IsFlag 56)
						(ClearFlag 56)
						(self enterRoom: -10 175 25 175)
					)
					(else
						(self enterRoom: -10 120 25 120)
					)
				)
			)
			(20
				(self enterRoom: 265 235 265 182)
			)
			(else
				(self enterRoom: 160 -5 160 60)
			)
		)
		(gAddToPics doit:)
	)

	(method (notify)
		(gMadMonk setScript: runAway)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gEgo onControl: 1) 2) (!= (gEgo priority:) 1))
				(gEgo setPri: 1)
			)
			((and (!= (gEgo onControl: 1) 2) (== (gEgo priority:) 1))
				(gEgo setPri: -1)
			)
		)
		(cond
			((or (self goingOut:) (self comingIn:)) 0)
			((> (gEgo x:) 310)
				(cond
					((< (gEgo y:) 80)
						(SetFlag 53)
					)
					((> (gEgo y:) 155)
						(SetFlag 55)
					)
				)
				(self leaveRoom: 18 320 (gEgo y:))
			)
			((< (gEgo x:) 10)
				(if (IsFlag 52)
					(self leaveRoom: 17 -10 (gEgo y:))
				else
					(cond
						((> (gEgo y:) 170)
							(SetFlag 55)
						)
						((< (gEgo y:) 75)
							(SetFlag 53)
						)
					)
					(self leaveRoom: 19 -10 (gEgo y:))
				)
			)
			((> (gEgo y:) 188)
				(self leaveRoom: 20 (gEgo x:) 235)
			)
			((< (gEgo y:) 30)
				(self leaveRoom: 22 (gEgo x:) -5)
			)
			(
				(and
					local1
					(not local0)
					(< (gEgo y:) 150)
					(or
						(and (== local1 1) (< (gEgo x:) 88))
						(and (== local1 2) (> (gEgo x:) 113))
					)
				)
				(gMadMonk setScript: runAway)
			)
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
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/ruin')
							(Said '//ruin')
						)
						(if (== global201 gCurRoomNum)
							(event claimed: 0)
						else
							(Print 21 0) ; "You are in another part of the ruins. There are ancient carvings of skulls in one wall."
						)
					)
					((or (Said '/memento,mori') (Said '//memento,mori'))
						(Print 21 1) ; ""Memento mori" is a Latin phrase meaning:  "Remember that thou must die"."
						(Print 21 2) ; "An object, such as a skull, is commonly called a memento mori because it is a reminder of inevitable death."
					)
					(
						(or
							(Said '/skull,carving')
							(Said '//skull,carving')
							(OnButton event 203 114 221 182)
						)
						(Print 21 3) ; "The carved skulls are memento mori, reminders of the death that awaits us all."
					)
					(
						(or
							(OnButton event 220 7 309 85)
							(OnButton event 182 86 254 182)
							(Said '/arch')
							(Said '//arch')
						)
						(Print 21 4) ; "The arch is the remnant of a doorway."
					)
					(
						(or
							(OnButton event 10 10 310 85)
							(OnButton event 10 145 181 182)
						)
						(Print 21 5) ; "The ruins are nothing but bits of wall and fallen rock with only the Tor beneath them."
					)
				)
			)
			((Said 'get/skull,carving')
				(Print 21 6) ; "This is no time to be plundering religious ruins."
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gTObj actor: 0 talkCue: 0 endTalk:)
				(gMadMonk
					setCycle: Walk
					setStep: 6 5
					illegalBits: 0
					ignoreActors: 1
				)
				(if (== local1 1)
					(gMadMonk setLoop: 5 setMotion: MoveTo -5 105 self)
					(= register (if (Random 0 1) 19 else 22))
				else
					(gMadMonk setLoop: 4 setMotion: MoveTo 326 90 self)
					(= register 18)
				)
			)
			(1
				(= global201 register)
				(gMadMonk setMotion: 0 setCycle: 0 setScript: 0)
			)
		)
	)
)

