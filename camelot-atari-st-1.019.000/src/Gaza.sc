;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Follow)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Gaza 0
	muleFollow 1
	proc107_2 2
)

(synonyms
	(coin copper dirham dinar)
	(jerusalem city)
	(hamid arab guide man)
)

(local
	local0
	[local1 7] = [0 165 190 160 190 100 180]
	[local8 7] = [0 130 60 65 0 95 105]
	[local15 7] = [0 265 270 260 260 195 240]
	[local22 7] = [0 165 90 100 100 140 120]
	local29
	local30
	local31
)

(procedure (proc107_2)
	(switch (Random 0 2)
		(0
			(Print 107 0) ; "There are countless rocks in this desert. This is yet another one."
		)
		(1
			(Print 107 1) ; "Aye, 'tis a rock. A very hot rock."
		)
		(2
			(Print 107 2) ; "One rock is much like any other in this merciless terrain."
		)
	)
)

(instance Gaza of Rgn
	(properties)

	(method (dispose)
		(if (== global189 8)
			(= global189 9)
		)
		(super dispose:)
		(DisposeScript 971)
	)

	(method (init)
		(Load rsVIEW 59)
		(Load rsVIEW 58)
		(Load rsVIEW 57)
		(Load rsSCRIPT 144)
		(Load rsSCRIPT 910)
		(Load rsSCRIPT 912)
		(if (!= global189 10)
			(Load rsSCRIPT 130)
		)
		(if (IsFlag 20)
			(Load rsSCRIPT 116)
			(Load rsSCRIPT 971)
		)
		(Load rsSOUND 91)
		(Load rsSOUND 58)
		(super init:)
		(if (== global204 0)
			(= global204 8000)
			(ClearFlag 98)
		)
		(if (== global205 0)
			(= global205 10000)
			(ClearFlag 107)
		)
		(if (< gPrevRoomNum 36)
			(SetFlag 20)
		)
		(if (IsFlag 20)
			(gCurRoom setRegions: 116) ; muleReg
			(gMuleObj setScript: muleFollow)
		)
		(switch gCurRoomNum
			(37
				(= local0 1)
			)
			(38
				(= local0 2)
			)
			(42
				(= local0 3)
			)
			(46
				(= local0 4)
			)
			(48
				(= local0 5)
			)
			(49
				(= local0 6)
			)
		)
		(if (== global177 gCurRoomNum)
			((= local30 (View new:))
				view: 397
				setLoop: global176
				setCel: 5
				posn: global174 global175
				init:
				stopUpd:
			)
		)
		(gEgo view: (if global124 6 else 0) looper: 0)
		(if (or (!= (gRegMusic number:) 58) (== gPrevRoomNum 41) (== gPrevRoomNum 35))
			(gRegMusic number: 58 priority: 1 loop: -1 play:)
		)
	)

	(method (doit &tmp temp0 temp1 [temp2 40])
		(if (IsFlag 124)
			(ClearFlag 124)
			(EgoDead 107 3) ; "This treacherous false guide has claimed yet another victim! Would that you had been a bit quicker with your sword on this occasion."
		)
		(if
			(and
				(== global125 4)
				(IsFlag 20)
				(< (gEgo distanceTo: gMuleObj) 50)
			)
			(= temp0
				(GetAngle
					(gEgo x:)
					(gEgo y:)
					(gMuleObj x:)
					(gMuleObj y:)
				)
			)
			(if
				(= temp1
					(if (and (not global169) (not (IsFlag 103)))
						(switch (gEgo loop:)
							(0
								(<= 0 temp0 180)
							)
							(1
								(<= 180 temp0 359)
							)
							(2
								(<= 90 temp0 270)
							)
							(3
								(or (<= 270 temp0 359) (<= 0 temp0 90))
							)
						)
					)
				)
				(gEgo
					view: 6
					setCycle: Walk
					ignoreActors: 0
					illegalBits: $1f40
					setScript: 0
				)
				(HandsOn)
				(User canControl: 1)
				(User canInput: 0)
				(= global125 0)
				(gEgo illegalBits: $8000 setScript: 0)
				(Print 107 4) ; "Do not swing your sword so close to your mule, Arthur. You might hurt the poor beast."
			)
		)
		(cond
			(
				(and
					(== global189 9)
					(not local29)
					(gEgo
						inRect:
							[local1 local0]
							[local8 local0]
							[local15 local0]
							[local22 local0]
					)
					(or
						(== (gEgo loop:) (if (== gCurRoomNum 48) 1 else 0))
						(== (gEgo loop:) 3)
					)
				)
				(= local29 1)
				(User canControl: 0)
				(gEgo setMotion: 0)
				(SetMenu 1281 112 0)
				((ScriptID 130 0) setScript: (ScriptID 180 0)) ; Jabir, killKing
			)
			((IsFlag 122)
				(= global154 1)
				(HandsOff)
				(ClearFlag 122)
				((ScriptID 130 0) dispose:) ; Jabir
				((= local30 (View new:))
					view: 397
					setLoop: global176
					setCel: 5
					posn: global174 global175
					init:
					stopUpd:
				)
			)
		)
		(cond
			((and global137 (not global124))
				(= global137 0)
			)
			((> global137 1)
				(-- global137)
			)
			((== global137 1)
				(= global137 0)
				(SetFlag 113)
			)
		)
		(cond
			((and (< global204 3000) (not (IsFlag 98)))
				(SetFlag 98)
			)
			((> global204 1)
				(if global124
					(-= global204 2)
				else
					(-- global204)
				)
			)
			((<= 1 global204 2)
				(= global204 0)
				(SetFlag 92)
			)
		)
		(cond
			((and (< global205 3000) (not (IsFlag 107)))
				(SetFlag 107)
			)
			((> global205 1)
				(-- global205)
			)
			((== global205 1)
				(= global205 2999)
			)
		)
		(cond
			(
				(and
					(not (IsFlag 98))
					(not (IsFlag 92))
					(== (gEgo view:) 57)
					(not (gEgo script:))
					(not global124)
				)
				(gEgo view: 0)
			)
			(
				(and
					(or (IsFlag 98) (IsFlag 92))
					(== (gEgo view:) 0)
					(not (gEgo script:))
					(not global124)
				)
				(gEgo view: 57)
				(if (not (IsFlag 85))
					(SetFlag 85)
					(Print 107 5) ; "Arthur, you must find water soon or you will perish!"
				)
			)
			((and (IsFlag 107) (IsFlag 20) (!= (gMuleObj view:) 404))
				(gMuleObj view: 423)
				(if (not (IsFlag 108))
					(SetFlag 108)
					(Print 107 6) ; "Your mule is suffering from lack of water!"
				)
			)
			(
				(and
					(not (gCurRoom goingOut:))
					(not (gCurRoom comingIn:))
					(not (gEgo script:))
					(not (gCurRoom script:))
					(not global169)
					global124
					(IsFlag 113)
				)
				(ClearFlag 113)
				(Print 107 7) ; "Arthur, holding your sword constantly at the ready only serves to tire you more quickly."
				(= global125 2)
			)
			(
				(and
					(not (gCurRoom goingOut:))
					(not (gCurRoom comingIn:))
					(not (gCurRoom script:))
					(not (gEgo script:))
					(not (IsFlag 82))
					(not global124)
					(not global169)
					(IsFlag 92)
				)
				(if (IsFlag 20)
					(gMuleObj setScript: 0 setCycle: 0 setMotion: 0)
					(DisposeScript 971)
				)
				(gEgo setScript: (ScriptID 144 0)) ; crawler
				(ClearFlag 92)
				(gRmMusic number: 91 priority: 4 loop: 1 play:)
				(gRegMusic stop:)
			)
		)
		(super doit:)
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
			((Said 'draw/blade')
				(if (not (and global169 (== global189 9)))
					(= global137 100)
				)
			)
			((and (== global189 10) (== gCurRoomNum global177))
				(if
					(or
						(MouseClaimed local30 event)
						(Said 'look/hamid')
						(Said 'ask[/merlin]/hamid')
					)
					(Print 107 8) ; "There are fleas and lice, drying blood and a ripe smell. There is nothing of any worth."
				else
					((ScriptID 203) handleEvent: event) ; GazaSaid
				)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(if
					(or
						(Said '/ass')
						(Said '//ass')
						(MouseClaimed gMuleObj event)
					)
					(cond
						((IsFlag 20)
							(if (IsFlag 107)
								(Print 107 9) ; "Your mule suffers and needs water as urgently as you do."
							else
								(event claimed: 0)
							)
						)
						((IsFlag 106)
							(Print 107 10) ; "You sold her to Mohammed, as you should remember."
						)
					)
				else
					((ScriptID 203) handleEvent: event) ; GazaSaid
				)
			)
			(else
				((ScriptID 203) handleEvent: event) ; GazaSaid
			)
		)
	)
)

(instance muleFollow of Script
	(properties)

	(method (doit)
		(if
			(and
				(not (gCurRoom goingOut:))
				(not (gCurRoom comingIn:))
				(not local31)
				(gEgo mover:)
				(not (gEgo script:))
				(not global169)
				(!= global189 9)
				(> (gEgo distanceTo: gMuleObj) 50)
			)
			(= local31 1)
			(gMuleObj setStep: 3 2 setMotion: Follow gEgo 50 setScript: 0)
		)
		(super doit:)
	)
)

