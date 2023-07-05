;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use Door)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0 param1 param2)
	(if (or (!= local5 param1) (!= local6 param2))
		(= local5 param1)
		(= local6 param2)
		(local4 posn: param1 param2)
	)
)

(instance rm310 of Rm
	(properties
		picture 310
		style 2
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 90)
		(super dispose:)
	)

	(method (init)
		(if (and (>= gTimeOfDay 4) [gEgoStats 9]) ; pick locks
			(Load rsSOUND (SoundFX 35))
		)
		(Load rsSOUND (SoundFX 46))
		(Load rsSOUND (SoundFX 28))
		(Load rsVIEW 310)
		(Load rsVIEW 515)
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(self setLocales: 811 801)
		(NormalEgo)
		(gEgo illegalBits: (if (> gTimeOfDay 4) -32768 else -30720) init:)
		(flameSound number: (SoundFX 46) init:)
		(teleport number: (SoundFX 28) init:)
		(= local5 252)
		(= local6 52)
		((= local4 (Prop new:))
			view: 310
			loop: 3
			posn: local5 52
			init:
			setPri: 10
		)
		((View new:)
			view: 310
			loop: 4
			cel: 0
			posn: 252 25
			setPri: 6
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 310
			loop: 7
			cel: 0
			posn: 35 43
			init:
			stopUpd:
			addToPic:
		)
		(flames init:)
		(if (< gTimeOfDay 4)
			(LOL init: cycleSpeed: 10 setCycle: Fwd startUpd:)
		)
		(= local1 (Prop new:))
		(local1
			view: 310
			loop: 0
			cel:
				(if (== gPrevRoomNum 314)
					(- (NumCels local1) 1)
				else
					0
				)
			posn: 253 114
			init:
			ignoreActors:
			stopUpd:
			setPri: 8
			cycleSpeed: 2
		)
		((= local0 (Door new:))
			view: 310
			loop: 1
			posn: 137 38
			doorControl: 16384
			entranceTo: 313
			locked: 1
			facingLoop: 3
			setPri: 5
			init:
		)
		((= local3 (Door new:))
			view: 310
			loop: 2
			posn: 6 148
			doorControl: 4096
			entranceTo: 311
			facingLoop: 1
			setPri: 9
			illegalBits: 0
			locked: (if gNight 1 else 0)
			init:
		)
		(switch gPrevRoomNum
			(0
				(gEgo posn: 318 177 setMotion: MoveTo 305 170)
			)
			(300
				(gEgo posn: 318 177 setMotion: MoveTo 305 170)
			)
			(311
				(gEgo posn: 35 141 loop: 0)
				(local3 close:)
			)
			(313
				(gEgo posn: 154 91)
				(local0 close:)
			)
			(314
				(teleport play:)
				(gEgo posn: 252 119)
				(local1 setCel: (- (NumCels local1) 1) setCycle: Beg)
			)
			(999
				(gEgo view: 515 setLoop: 3 cel: 5 init: setScript: egoWakes)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit:)
		(cond
			((> (gEgo x:) 318)
				(= global113 0)
				(gCurRoom newRoom: 300)
			)
			(
				(and
					(== (gEgo onControl: 1) 8192)
					(not local2)
					(== (gEgo loop:) 3)
				)
				(= local2 1)
				(local1 setScript: magicDoorScript)
			)
		)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(= temp2 local5)
		(= temp3 local6)
		(cond
			((<= temp1 125)
				(= temp3 54)
			)
			((<= temp1 140)
				(= temp3 53)
			)
			(else
				(= temp3 52)
			)
		)
		(cond
			((<= temp0 160)
				(= temp2 246)
				(= temp3 52)
			)
			((<= temp0 200)
				(= temp2 248)
				(= temp3 52)
			)
			((<= temp0 240)
				(= temp2 250)
			)
			((<= temp0 270)
				(= temp2 252)
			)
			((<= temp0 290)
				(= temp2 254)
			)
			(else
				(= temp2 256)
			)
		)
		(localproc_0 temp2 temp3)
	)

	(method (notify param1)
		(cond
			((!= param1 1))
			((not (local0 locked:))
				(HighPrint 310 0) ; "The door isn't locked. Just turn around."
			)
			((not (TrySkill 9 30 global189)) ; pick locks
				(HighPrint 310 1) ; "Picking locks looked a lot easier in the instruction book."
			)
			((and (IsFlag 92) (< global111 gDay))
				(HighPrint 310 2) ; "The owners seem to have been made nervous by the recent rash of house burglaries. The door is barred from the inside. But you do get some valuable lock-picking practice."
			)
			(else
				(lockSound number: (SoundFX 35) init: play:)
				(HighPrint 310 3) ; "You hear a "Snick!". The lock is open!"
				(local0 facingLoop: (gEgo loop:) locked: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said 'look/lol,woman')
				(HighPrint 310 4) ; "She seems to have retired...or maybe she's at the tavern."
			)
			((Said 'look/hasp')
				(cond
					((== (gEgo onControl: 1) 8192)
						(HighPrint 310 5) ; "This (door?) doesn't have a visible lock."
					)
					((== (gEgo onControl: 1) 16384)
						(HighPrint 310 6) ; "Not the sturdiest you've ever seen."
					)
					(else
						(NotClose)
					)
				)
			)
			((Said 'knock,open/door')
				(cond
					(
						(and
							(== (gEgo onControl: 1) 8192)
							(not local2)
							(!= (gEgo loop:) 3)
						)
						(HighPrint 310 7) ; "Turn around and go on in."
					)
					((== (gEgo onControl: 1) 16384)
						(if (< gTimeOfDay 4)
							(HighPrint 310 8) ; "The door appears to be locked. It also appears that the occupant is taking her nap at the bottom of the stairs right now."
						else
							(HighPrint 310 9) ; "No one seems to be home, and the door is securely locked."
						)
					)
					((== (gEgo onControl: 1) 4096)
						(if gNight
							(HighPrint 310 10) ; "The door appears to be locked."
						else
							(HighPrint 310 7) ; "Turn around and go on in."
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'look[<at,around][/!*,hamlet,street,building]')
				(HighPrint 310 11) ; "You have come to the end of the main street. The town wall is to the south. You have an eerie feeling that someone is watching you."
			)
			((or (MouseClaimed local1 event 3) (Said 'look/shop,shop[<magic]'))
				(HighPrint 310 12) ; "Not only does this building look weird, but it feels weird to be near it."
			)
			((or (MouseClaimed local0 event 3) (Said 'look/house[<lol,woman]'))
				(HighPrint 310 13) ; "The house looks closed up. There is no sign of the Little Old Lady."
			)
			((or (MouseClaimed local3 event 3) (Said 'look/hall[<club]'))
				(if gNight
					(HighPrint 310 14) ; "The Guild Hall building appears to be dark and closed up."
				else
					(HighPrint 310 15) ; "You can just see a thin thread of light under the door, so there is probably someone inside."
				)
			)
			((Said 'look/fence')
				(HighPrint 310 16) ; "The fence around the Little Old Lady's house looks like it's made of wrought iron."
			)
			((or (MouseClaimed onEye event 3) (Said 'look/eye'))
				(HighPrint 310 17) ; "There's no getting around it...a shop with its eye on you makes you nervous."
			)
			((MouseClaimed onMagicSign event 3)
				(HighPrint 310 18) ; "It would seem that the strangely decorated building is involved in the magic trade."
			)
			((MouseClaimed onGuildSign event 3)
				(HighPrint 310 19) ; "Judging from what the sign says, the building at the end of the street is the Guild Hall."
			)
			((Said 'look/sign')
				(if (> (gEgo x:) 200)
					(HighPrint 310 18) ; "It would seem that the strangely decorated building is involved in the magic trade."
				else
					(HighPrint 310 19) ; "Judging from what the sign says, the building at the end of the street is the Guild Hall."
				)
			)
			(
				(or
					(and
						(not (MouseClaimed onMagicSign event 3))
						(MouseClaimed flames event 3)
					)
					(Said 'look/flame')
				)
				(if (> (flameScript state:) 0)
					(HighPrint 310 20) ; "Isn't it hard to tear your eyes away? "PYROMANIA.""
				else
					(HighPrint 310 21) ; "Flames? What flames? You don't see any flames."
				)
			)
		)
	)
)

(instance magicDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(teleport play:)
				(local1 setCycle: End self)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 254 108 self)
			)
			(2
				(gCurRoom newRoom: 314)
			)
		)
	)
)

(instance flames of Prop
	(properties
		y 34
		x 253
		view 310
		loop 5
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(self setScript: flameScript)
	)
)

(instance flameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client stopUpd:)
				(= register (Random 1 3))
				(= cycles (Random 60 150))
			)
			(1
				(client setCycle: End self)
				(= cycles 3)
			)
			(2
				(flameSound loop: 1 play:)
			)
			(3
				(if (-- register)
					(self changeState: 1)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance onMagicSign of RFeature
	(properties
		nsTop 1
		nsLeft 216
		nsBottom 19
		nsRight 280
	)
)

(instance onGuildSign of RFeature
	(properties
		nsTop 22
		nsLeft 3
		nsBottom 38
		nsRight 71
	)
)

(instance onEye of RFeature
	(properties
		nsTop 44
		nsLeft 234
		nsBottom 59
		nsRight 269
	)
)

(instance lockSound of Sound
	(properties
		number 35
	)
)

(instance flameSound of Sound
	(properties
		priority 10
	)
)

(instance teleport of Sound
	(properties
		priority 12
	)
)

(instance egoWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(HighPrint 310 22) ; "However, this was not a good place to sleep. You're stiff and sore all over and your wallet feels very light."
				(= [gInvNum 1] 0) ; silver
				(= [gInvNum 2] 0) ; gold
				(HandsOn)
			)
		)
	)
)

(instance LOL of Prop
	(properties
		y 125
		x 167
		view 310
		loop 6
	)

	(method (handleEvent event)
		(cond
			((or (MouseClaimed LOL event 3) (Said 'look/lol,woman'))
				(HighPrint 310 23) ; "She's deeply asleep in her rocker."
			)
			((Said 'look/rocker,chair')
				(HighPrint 310 24) ; "In it sits the Little Old Lady, asleep."
			)
			((Said 'awaken/lol,woman')
				(HighPrint 310 25) ; "She's really sleeping soundly and doesn't notice your presence."
			)
			((Said 'ask,talk')
				(HighPrint 310 26) ; ""ZZZZZZZZZZZZZZZZZZZZ"!"
				(HighPrint 310 27) ; ""Grmpf..snrt..hmphspft"!"
				(HighPrint 310 26) ; ""ZZZZZZZZZZZZZZZZZZZZ"!"
			)
			((or (MouseClaimed local0 event 3) (Said 'look/house[<lol,woman]'))
				(HighPrint 310 28) ; "This looks like a nice, neat little house. There is a grandmotherly little old lady rocking on the front lawn."
			)
		)
	)
)

