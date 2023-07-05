;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm18 0
)

(synonyms
	(doug man)
)

(local
	local0
	local1
	local2
)

(instance Rm18 of eRoom
	(properties
		picture 18
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
		(self style: (if (== gPrevRoomNum 17) 17 else 0))
		(super init:)
		(self setRegions: 104) ; glastonburyTor
		(if (and (== global201 gCurRoomNum) (not (IsFlag 48)) (not (IsFlag 49)))
			((gTObj tWindow:) brLeft: 50 brRight: 250 brBottom: 290)
			(if (!= gPrevRoomNum 21)
				(gMadMonk posn: 36 59 loop: 1)
				(= local2 1)
			else
				((gTObj tWindow:) brLeft: 12)
				(gMadMonk posn: 183 104 loop: 0)
				(= local2 2)
			)
		)
		(cond
			((IsFlag 54)
				(ClearFlag 54)
				(switch gPrevRoomNum
					(19
						(self enterRoom: 320 45 290 45)
					)
					(22
						(self enterRoom: 285 -5 285 45)
					)
				)
			)
			((IsFlag 53)
				(ClearFlag 53)
				(switch gPrevRoomNum
					(21
						(self enterRoom: -10 45 35 45)
					)
					(22
						(self enterRoom: 30 -5 30 45)
					)
				)
			)
			((IsFlag 56)
				(ClearFlag 56)
				(switch gPrevRoomNum
					(19
						(self enterRoom: 320 170 290 170)
					)
					(20
						(self enterRoom: 316 217 288 185)
					)
				)
			)
			((IsFlag 55)
				(ClearFlag 55)
				(switch gPrevRoomNum
					(20
						(self enterRoom: 0 219 19 170)
					)
					(21
						(self enterRoom: -10 157 25 157)
					)
				)
			)
			(else
				(switch gPrevRoomNum
					(19
						(self enterRoom: 320 110 290 110)
					)
					(20
						(self enterRoom: 127 235 127 182)
					)
					(21
						(self enterRoom: -10 110 20 110)
					)
					(22
						(self enterRoom: 160 -5 160 60)
					)
					(else
						(self enterRoom: 150 90 150 115)
					)
				)
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
			((and (& (gEgo onControl:) $4000) (!= (gEgo priority:) 11))
				(gEgo setPri: 11)
			)
			(
				(and
					(not (& (gEgo onControl:) $4000))
					(== (gEgo priority:) 11)
				)
				(gEgo setPri: -1)
			)
		)
		(cond
			((or (self goingOut:) (self comingIn:)) 0)
			((and (< gPrevRoomNum 18) (not local0))
				(= local0 1)
				(Print 18 0 #at -1 110) ; "Ah, there you are! That was not my doing. You have been brought by another power to the center of the ruins on Glastonbury Tor."
			)
			((> (gEgo x:) 310)
				(cond
					((< (gEgo y:) 50)
						(SetFlag 54)
					)
					((> (gEgo y:) 150)
						(SetFlag 56)
					)
				)
				(self leaveRoom: 19 320 (gEgo y:))
			)
			((< (gEgo x:) 10)
				(cond
					((< (gEgo y:) 52)
						(SetFlag 53)
					)
					((> (gEgo y:) 150)
						(SetFlag 55)
					)
				)
				(self leaveRoom: 21 -10 (gEgo y:))
			)
			((> (gEgo y:) 188)
				(cond
					((< (gEgo x:) 45)
						(SetFlag 55)
					)
					((> (gEgo x:) 260)
						(SetFlag 56)
					)
				)
				(self leaveRoom: 20 (gEgo x:) 235)
			)
			((and (< (gEgo y:) 36) (< 91 (gEgo x:) 257))
				(gEgo illegalBits: 0)
				(self leaveRoom: 22 (gEgo x:) -5)
			)
			((< (gEgo y:) 20)
				(cond
					((< (gEgo x:) 91)
						(SetFlag 53)
					)
					((> (gEgo x:) 257)
						(SetFlag 54)
					)
				)
				(self leaveRoom: 22 (gEgo x:) -5)
			)
			(
				(or
					(and
						(== local2 1)
						(not local1)
						(gEgo inRect: 0 50 80 90)
					)
					(and
						(== local2 2)
						(not local1)
						(gEgo inRect: 133 51 279 155)
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
					(OnButton event 10 10 94 53)
					(OnButton event 235 6 308 54)
					(OnButton event 10 100 66 182)
					(OnButton event 241 87 309 182)
				)
				(Print 18 1) ; "The ruins offer little in the way of defense or concealment."
			)
			(
				(and
					(or
						(Said 'talk,ask[/merlin]>')
						(Said 'tell[/me]>')
						(Said 'are<where>')
						(Said 'look>')
					)
					(or
						(Said 'look[<at,around][/!*][/!*]')
						(Said 'look/room[/!*]')
						(Said '/ruin')
						(Said '//ruin')
					)
				)
				(if (== global201 gCurRoomNum)
					(event claimed: 0)
				else
					(Print 18 2) ; "You are in the center of the ruins on Glastonbury Tor."
				)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gTObj actor: 0 talkCue: 0 endTalk:)
				(gMadMonk
					setCycle: Walk
					setStep: 6 5
					illegalBits: 0
					ignoreActors: 1
				)
				(if (== local2 1)
					(gMadMonk setLoop: 5 setMotion: MoveTo -5 62 self)
					(= register 21)
				else
					(gMadMonk setLoop: 4 setMotion: MoveTo 326 116 self)
					(= register 19)
				)
			)
			(1
				(= global201 register)
				(gMadMonk setMotion: 0 setCycle: 0 dispose:)
			)
		)
	)
)

