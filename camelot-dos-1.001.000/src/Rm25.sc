;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	Rm25 0
)

(local
	local0
	local1
)

(instance funkyFade of Prop
	(properties
		view 36
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self
			posn: (+ (gEgo x:) 2) (gEgo y:)
			setCycle: Fwd
			setPri: (- (gEgo priority:) 1)
			ignoreActors: 1
		)
	)
)

(instance Rm25 of eRoom
	(properties
		picture 25
		style 8
	)

	(method (init)
		(Load rsVIEW 36)
		(super init:)
		(= global118 0)
		(self setRegions: 106) ; otMoor
		(if global119
			(= global119 0)
			(if (not (IsFlag 312))
				((ScriptID 124) notify: 3) ; WhirlWind
			)
		)
		(SetFlag 312)
		(if (== global116 1)
			(self setRegions: 113) ; horseReg
		)
		(if (and (== global116 2) (== global115 gCurRoomNum))
			(self setRegions: 113) ; horseReg
			(gHorseObj loop: 0 posn: 106 115)
		)
		(switch gPrevRoomNum
			(24
				(gEgo loop: 0)
				(self enterRoom: -10 125 25 125)
				(if (IsFlag 20)
					(gMuleObj loop: 0)
					(self muleEnterRoom: -15 135 30 135)
				)
			)
			(26
				(self enterRoom: (gEgo x:) 35 (gEgo x:) 60)
			)
			(else
				(self setScript: egoTeleport)
			)
		)
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((== global116 1) 0)
			(
				(and
					(& (gEgo onControl: 1) $4000)
					(!= ((ScriptID 106 1) loop:) 1) ; footSnow
				)
				((ScriptID 106 1) setLoop: 1) ; footSnow
			)
			(
				(and
					(!= (gEgo onControl: 1) 16384)
					(== ((ScriptID 106 1) loop:) 1) ; footSnow
				)
				((ScriptID 106 1) setLoop: 0) ; footSnow
			)
		)
		(cond
			(global80 0)
			(
				(and
					(== global116 1)
					(& (gEgo onControl: 1) $4000)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: horseAwayFromIce)
			)
			((and (> (gEgo x:) 300) (< (gEgo y:) 145))
				(Print 25 0) ; "A ridge of ice prevents you from going any further in this direction."
				(gEgo setMotion: MoveTo (- (gEgo x:) 6) (gEgo y:))
			)
			((and (> (gEgo y:) 145) (> (gEgo x:) 300))
				(Print 25 1) ; "A huge bank of snow blocks your path."
				(gEgo setMotion: MoveTo (- (gEgo x:) 6) (gEgo y:))
			)
			((< (gEgo x:) 10)
				(self leaveRoom: 24 -15 (gEgo y:))
			)
			((< (gEgo y:) 30)
				(self leaveRoom: 26 (gEgo x:) -5)
			)
		)
		(if local0
			(-- local0)
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
				(if
					(or
						(Said 'look[<at,around][/!*][/!*]')
						(Said 'look/room[/!*]')
						(Said '<around')
						(Said '/moor,ot,lake')
						(Said '//moor,ot,lake')
						(OnButton event 26 7 282 95)
					)
					(if (not (IsFlag 65))
						(Print 25 2) ; "You have reached what would normally be the shore of the lake known as Ot Moor. It is entirely frozen over."
					else
						(Print 25 3) ; "It will take longer to remove the ice than to make it. But the thaw begins slowly and the ice is surely more dangerous than it was before."
					)
				)
			)
			((and (== global116 2) (Said 'get,pull/charger'))
				(Print 25 4) ; "Your horse is too wise to venture onto the ice."
			)
			((and (IsFlag 20) (Said 'get,pull/ass'))
				(Print 25 5) ; "Your mule is too intelligent to follow you onto dangerous ice."
			)
			((Said 'climb/mesa,ice')
				(Print 25 6) ; "That would not be safe in all your heavy gear."
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 917)
	)
)

(instance horseAwayFromIce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 12) self
				)
			)
			(1
				(Print 25 7) ; "Your horse knows better than to walk upon thin ice."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance egoTeleport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 36
					posn: 160 115
					loop: 1
					cel: 4
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(1
				(gEgo view: 0 loop: 0 cel: 1)
				(gEgo cycleSpeed: 0 setCycle: Walk)
				(funkyFade init:)
				(= seconds 3)
			)
			(2
				(funkyFade dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

