;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use System)

(public
	Rm19 0
)

(synonyms
	(doug man)
)

(local
	local0
)

(instance Rm19 of eRoom
	(properties
		picture 19
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
					(18 3)
					(20 4)
					(21 2)
					(22 5)
					(else 8)
				)
		)
		(super init:)
		(self setRegions: 104) ; glastonburyTor
		(if (and (== global201 gCurRoomNum) (not (IsFlag 48)) (not (IsFlag 49)))
			((gTObj tWindow:) brLeft: 50 brRight: 250 brBottom: 290)
			(if (Random 0 1)
				(gMadMonk posn: 108 101 loop: 1)
			else
				(gMadMonk posn: 92 104 loop: 0)
			)
		)
		(switch gPrevRoomNum
			(18
				(cond
					((IsFlag 54)
						(ClearFlag 54)
						(self enterRoom: -10 52 34 52)
					)
					((IsFlag 56)
						(ClearFlag 56)
						(self enterRoom: -10 175 25 175)
					)
					(else
						(self enterRoom: -10 110 25 110)
					)
				)
			)
			(20
				(self enterRoom: 130 235 130 182)
			)
			(21
				(cond
					((IsFlag 53)
						(ClearFlag 53)
						(self enterRoom: 320 52 290 52)
					)
					((IsFlag 55)
						(ClearFlag 55)
						(self enterRoom: 320 175 290 175)
					)
					(else
						(self enterRoom: 320 104 268 104)
					)
				)
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

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(
				(and
					(= temp0 (& (gEgo onControl: 1) $0002))
					(!= (gEgo priority:) 1)
				)
				(gEgo setPri: 1)
			)
			((and (not temp0) (== (gEgo priority:) 1))
				(gEgo setPri: -1)
			)
		)
		(cond
			((or (self goingOut:) (self comingIn:)) 0)
			((> (gEgo x:) 310)
				(if (IsFlag 52)
					(self leaveRoom: 17 320 (gEgo y:))
				else
					(cond
						((> (gEgo y:) 170)
							(SetFlag 56)
						)
						((== (gEgo onControl: 1) 2)
							(SetFlag 54)
						)
					)
					(self leaveRoom: 21 320 (gEgo y:))
				)
			)
			((< (gEgo x:) 10)
				(cond
					((> (gEgo y:) 173)
						(SetFlag 56)
					)
					((< (gEgo y:) 54)
						(SetFlag 54)
					)
				)
				(self leaveRoom: 18 -10 (gEgo y:))
			)
			((> (gEgo y:) 188)
				(self leaveRoom: 20 (gEgo x:) 235)
			)
			((< (gEgo y:) 10)
				(self leaveRoom: 22 (gEgo x:) -5)
			)
			(
				(and
					(gCast contains: gMadMonk)
					(not local0)
					(gEgo inRect: 52 71 160 124)
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
					((OnButton event 10 10 261 55)
						(Print 19 0) ; "The ruins are nothing but bits of wall and fallen rock with only the Tor beneath them."
					)
					(
						(or
							(OnButton event 10 106 309 182)
							(Said '/arch')
							(Said '//arch')
						)
						(Print 19 1) ; "What remains would have been the arch of a doorway."
					)
					((OnButton event 262 14 309 136)
						(Print 19 2) ; "This arch is the frame of a doorway."
					)
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
							(Print 19 3) ; "You are in another part of the ruins."
						)
					)
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
				(= local0 1)
				(gTObj actor: 0 talkCue: 0 endTalk:)
				(gMadMonk
					setCycle: Walk
					setStep: 6 5
					illegalBits: 0
					ignoreActors: 1
				)
				(if (> (gEgo x:) (gMadMonk x:))
					(gMadMonk setLoop: 5 setMotion: MoveTo -5 99 self)
					(= register 18)
				else
					(gMadMonk setLoop: 4 setMotion: MoveTo 326 101 self)
					(= register (if (Random 0 1) 21 else 22))
				)
			)
			(1
				(= global201 register)
				(gMadMonk setMotion: 0 setCycle: 0 dispose:)
			)
		)
	)
)

