;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use jet)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	local0
	[local1 100]
	local101
	local102
	local103
	local104
)

(instance hijackMusic of Sound
	(properties
		number 36
		priority 2
		loop -1
	)
)

(instance hijackGunFire of Sound
	(properties
		number 41
		priority 5
	)
)

(instance hijacker1Timer of Timer
	(properties)
)

(instance hijacker2Timer of Timer
	(properties)
)

(instance willKillTimer of Timer
	(properties)
)

(instance rm41 of Rm
	(properties
		picture 40
		style 0
	)

	(method (dispose)
		(hijacker1Timer dispose: delete:)
		(hijacker2Timer dispose: delete:)
		(willKillTimer dispose: delete:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 26)
		(Load rsVIEW 82)
		(Load rsVIEW 83)
		(Load rsVIEW 84)
		(Load rsVIEW 23)
		(Load rsVIEW 24)
		(Load rsVIEW 20)
		(Load rsSOUND 36)
		(Load rsSOUND 41)
		(Load rsSOUND 41)
		(super init:)
		(self setLocales: 154)
		(gEgo
			view: 82
			setLoop: 3
			setCel: 255
			ignoreActors:
			illegalBits: 0
			posn: 212 72
			setPri: 3
			init:
		)
		((= global112 (Act new:))
			view: 82
			illegalBits: 0
			ignoreActors:
			setPri: 0
			setLoop: 4
			setCel: 255
			posn: 200 68
			init:
		)
		((= global198 (Act new:))
			view: 26
			posn: 255 77
			loop: 2
			cel: 0
			setCycle: Walk
			init:
		)
		((= local104 (Prop new:))
			view: 82
			posn: 271 55
			loop: 8
			cel: 0
			setPri: 0
			ignoreActors:
			stopUpd:
			cycleSpeed: 1
			init:
		)
		((Prop new:) view: 82 posn: 51 191 loop: 2 cel: 0 setPri: 15 addToPic:)
		((= global199 (Act new:))
			view: 24
			posn: 60 1060
			loop: 1
			cel: 0
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
			init:
		)
		((= global200 (Act new:))
			view: 23
			posn: 70 1060
			loop: 1
			cel: 0
			setCycle: Walk
			illegalBits: 0
			ignoreActors:
			init:
		)
		(proc154_2)
		(= global201 1)
		(= local101 1)
		(= global211 0)
		(= global212 0)
		(HandsOn)
		(User canControl: 0)
		(gCurRoom setScript: hijackersApproach)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((== (= temp0 (event message:)) KEY_F8)
						(event claimed: 1)
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(Print 41 0) ; "You don't have your gun."
							)
							((== local101 1)
								(Print 41 1) ; "You don't need to use your gun now."
							)
							((== local101 0) 0)
							(global202
								(proc154_1 41 2)
							)
							(global201
								(= local102 1)
								(= global204 1)
								(= global205 0)
								(gEgo setScript: egoAction)
								(egoAction changeState: 1)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((== temp0 KEY_F10)
						(event claimed: 1)
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							((not global204)
								(Print 41 3) ; "It is standard police procedure to draw your gun before firing it."
							)
							((== local101 1)
								(Print 41 1) ; "You don't need to use your gun now."
							)
							((or (== local101 0) global201)
								(event claimed: 1)
							)
							((== [global215 global207] 0)
								(Print 41 4 #time 3) ; "CLICK!"
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance hijackersApproach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global200 setScript: hijacker2Approach)
				(= cycles 10)
			)
			(1
				(global199 posn: 60 160 setMotion: MoveTo 235 72 self)
			)
			(2
				(global199 setMotion: MoveTo 262 72 self)
			)
			(3
				(global199 loop: 2)
				(global199 setScript: hijacker1Actions)
				(gCurRoom setScript: StageThree)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/hijacker')
								(proc154_1 41 5)
							)
							((Said '/attendant')
								(proc154_1 41 6)
							)
							((Said '/men,man')
								(proc154_1 41 7)
							)
							((Said '/friend')
								(proc154_1 41 8)
							)
							((Said '/passenger')
								(proc154_1 41 9)
							)
						)
					)
					((Said 'talk>')
						(cond
							((Said '/attendant')
								(proc154_1 41 10)
							)
							((Said '/friend')
								(proc154_1 41 11)
							)
							((Said '/passenger')
								(proc154_1 41 12)
							)
						)
					)
				)
			)
		)
	)
)

(instance hijacker2Approach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global200 posn: 70 160 setMotion: MoveTo 78 148 self)
			)
			(1
				(global200 setMotion: MoveTo 245 72 self)
			)
			(2
				(global200 setMotion: MoveTo 268 60 self)
			)
			(3
				(local104 startUpd: setCycle: End self)
			)
			(4
				(local104 stopUpd:)
				(global200 setPri: 0 setMotion: MoveTo 280 50 self)
			)
			(5
				(local104 startUpd: setCycle: Beg self)
				(global200 posn: 280 1050)
				(global200 setScript: 0)
			)
		)
	)
)

(instance StageThree of Script
	(properties)

	(method (init)
		(Load rsVIEW 24)
		(Load rsVIEW 23)
		(Load rsVIEW 26)
		(Load rsVIEW 27)
	)

	(method (doit &tmp temp0)
		(User canControl: 0)
		(if global205
			(= temp0 global205)
			(= global205 0)
			(= local103 1)
			(if (== temp0 2)
				(switch local101
					(3
						(if (not (global198 script:))
							(global198 setScript: stewardessDies)
						)
					)
					(4
						(= local101 2)
						(cond
							((or global197 (not global166))
								(egoKilledByOne changeState: 0)
							)
							((< (hijacker1Actions state:) 8)
								(hijacker1Actions changeState: 8)
							)
						)
					)
					(5
						(cond
							((or global197 (not global166))
								(hijacker2Actions changeState: 5)
							)
							((< (hijacker2Actions state:) 8)
								(hijacker2Actions changeState: 8)
							)
						)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'kill,hit')
						(proc154_1 41 13)
					)
					((Said 'fire/hijacker,man')
						(Print 41 14) ; "Just face and shoot."
					)
					((Said 'stand,(get<up)')
						(cond
							((not global201)
								(proc154_1 41 15)
							)
							(global202
								(proc154_1 41 2)
							)
							(else
								(gEgo setScript: egoAction)
								(egoAction changeState: 1)
							)
						)
					)
					((Said 'sat')
						(if (not global201)
							(gEgo setScript: egoAction)
							(egoAction changeState: 3)
						else
							(proc154_1 41 16 67 20 20 33 gSmallFont)
						)
					)
					((Said 'look>')
						(cond
							((Said '/hijacker,man')
								(proc154_1 41 17)
							)
							((Said '/attendant')
								(proc154_1 41 18)
							)
							((Said '/9mm')
								(proc154_1 41 19)
							)
							((Said '/friend')
								(proc154_1 41 20)
							)
							((Said '/passenger')
								(proc154_1 41 21)
							)
							((Said '[<at,around][/(!*,chamber,airplane)]')
								(proc154_1 41 22)
							)
						)
					)
					((Said 'talk>')
						(cond
							((Said '/hijacker')
								(proc154_1 41 23)
							)
							((Said '/attendant')
								(proc154_1 41 24)
							)
							((Said '/friend')
								(proc154_1 41 25)
							)
							((Said '/passenger')
								(proc154_1 41 26)
							)
						)
					)
				)
			)
		)
	)
)

(instance egoAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo
					view: 82
					ignoreActors:
					posn: 212 72
					setLoop: 3
					setCel: 4
					cycleSpeed: 1
					setMotion: 0
					setPri: 3
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: (if (not local102) 0 else 6)
					posn: 229 59
					setLoop: -1
					loop: 0
					setCel: 0
					setPri: -1
					cycleSpeed: 0
					ignoreActors: 0
					illegalBits: $8000
					setCycle: Walk
				)
				(if
					(and
						(== (global199 script:) hijacker1Actions)
						(< (hijacker1Actions state:) 7)
					)
					(willKillTimer setCycle: egoKilledByOne 35)
				)
				(= local102 0)
				(= global201 0)
				(HandsOn)
				(RedrawCast)
				(User canControl: 0)
				(client setScript: 0)
			)
			(3
				(= global201 1)
				(HandsOff)
				(willKillTimer dispose: delete:)
				(gEgo
					view: 82
					setLoop: 3
					setCel: 0
					ignoreActors:
					illegalBits: 0
					posn: 212 72
					cycleSpeed: 1
					setMotion: 0
					setPri: 3
					setCycle: End self
				)
			)
			(4
				(HandsOn)
				(gEgo cycleSpeed: 0)
				(User canControl: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance stewardessDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 3)
				(hijacker1Timer dispose: delete:)
				(willKillTimer dispose: delete:)
				(egoKilledByOne changeState: 0)
				(cond
					((== (global198 loop:) 1)
						(global198
							view: 83
							loop: 4
							cel: 0
							posn: 251 76
							setCycle: End self
						)
					)
					((!= local0 0)
						(global198
							view: 83
							loop: 4
							posn: 251 76
							setCycle: End self
						)
					)
					(else
						(Print 41 27) ; "Self cueing"
						(self cue:)
					)
				)
			)
			(1
				(global198 posn: 251 76 loop: 4 setCel: 255)
				(User canControl: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance egoIsDying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 83
					loop: 6
					cel: 0
					illegalBits: 0
					ignoreActors:
					posn: (- (gEgo x:) 15) (+ (gEgo y:) 2)
					setPri: 3
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setPri: 0 setCycle: CT 4 1 self)
			)
			(2
				(Timer setReal: self 2)
			)
			(3
				(EgoDead @local1)
			)
		)
	)
)

(instance egoKilledByOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local101 0)
				(hijacker1Timer dispose: delete:)
				(willKillTimer dispose: delete:)
				(gEgo cel: 7)
				(global199
					view: 83
					loop: 5
					cel: 0
					posn: (- (global199 x:) 14) (global199 y:)
					setCycle: End self
				)
			)
			(1
				(hijackMusic stop:)
				(hijackGunFire play:)
				(if local103
					(cond
						((== local0 3)
							(Format @local1 41 28) ; "You fire at the hijacker but unfortunately, the stewardess was in the way. You hit her and the hijacker kills you."
						)
						(global197
							(Format @local1 41 29) ; "You fire at the hijacker but miss because of your intoxicated condition. Unfortunately he didn't miss you!"
						)
						(else
							(Format @local1 41 30) ; "You fire at the hijacker but miss because your gun is not sighted."
						)
					)
				else
					(Format @local1 41 31) ; "Because of your furtive movement, the hijacker unloads on you."
				)
				(gEgo setScript: egoIsDying)
			)
		)
	)
)

(instance hijacker1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global198 posn: (global198 x:) 1000)
				(global199
					view: 83
					loop: 0
					cel: 0
					posn: 256 76
					init:
					setCycle: End self
				)
			)
			(1
				(global199
					view: 83
					loop: 7
					cel: 0
					posn: 273 75
					setCycle: Fwd
					cycleSpeed: 2
				)
				(global198
					view: 83
					loop: 1
					cel: 0
					posn: 253 76
					show:
					cycleSpeed: 2
					setCycle: Fwd
				)
				(= cycles 10)
			)
			(2
				(= local101 3)
				(hijackMusic play:)
				(proc154_1 41 32)
				(proc154_1 41 33)
				(proc154_1 41 34)
				(proc154_1 41 35)
				(proc154_1 41 36)
				(proc154_1 41 37)
				(proc154_1 41 38)
				(hijacker1Timer setCycle: self 40)
			)
			(3
				(= local101 4)
				(global198
					loop: 2
					cel: 0
					posn: 251 76
					cycleSpeed: 0
					setCycle: End self
				)
				(= local0 1)
			)
			(4
				(= local0 0)
				(hijacker1Timer setCycle: self 50)
			)
			(5
				(cond
					((> (egoKilledByOne state:) 0) 0)
					((not global201)
						(egoKilledByOne changeState: 0)
					)
					(else
						(= local0 2)
						(global198
							view: 84
							loop: 3
							cel: 0
							posn: 256 76
							cycleSpeed: 0
							setCycle: End self
						)
						(global199
							view: 84
							loop: 2
							cel: 0
							posn: 256 76
							cycleSpeed: 0
							setCycle: End
						)
						(= local101 3)
					)
				)
			)
			(6
				(= local0 0)
				(global198
					view: 83
					posn: 253 76
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: Fwd
				)
				(global199
					view: 83
					posn: 273 75
					loop: 7
					cel: 0
					cycleSpeed: 2
					setCycle: Fwd
				)
				(hijacker1Timer setCycle: self 80)
			)
			(7
				(= local101 0)
				(HandsOff)
				(hijackMusic fade:)
				(EgoDead
					{ Because you failed to take action, the hijackers have succeeded with their sinister plot. You will live out the rest of your life in Bum Suk Egypt.}
				)
			)
			(8
				(hijackMusic stop:)
				(= local101 2)
				(hijacker1Timer dispose: delete:)
				(willKillTimer dispose: delete:)
				(global199
					view: 84
					illegalBits: 0
					ignoreActors:
					loop: 0
					cel: 0
					posn: 263 75
					setCycle: End self
				)
			)
			(9
				(global199 setPri: 1)
				(global200 setScript: hijacker2Actions)
				(SetFlag 125)
				(SetScore 6)
				(client setScript: 0)
			)
		)
	)
)

(instance hijacker2Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hijacker2Timer setReal: self 1)
			)
			(1
				(local104 setCycle: End self)
			)
			(2
				(= local101 5)
				(local104 setCycle: Beg)
				(global200
					view: 27
					loop: 2
					illegalBits: 0
					ignoreActors:
					posn: 280 60
					setCycle: Walk
					setMotion: MoveTo 268 60 self
				)
			)
			(3
				(global200 loop: 0)
				(hijacker2Timer setReal: self 2)
			)
			(4
				(global200 loop: 5)
				(hijacker2Timer setCycle: self 4)
			)
			(5
				(HandsOff)
				(= local101 0)
				(global200 setCycle: End self)
			)
			(6
				(hijackGunFire play:)
				(global200 setCycle: Beg)
				(Format @local1 41 39) ; "The masked hijacker kills you, avenging his companions death."
				(if global201
					(gEgo
						view: 83
						loop: 6
						setCel: 255
						illegalBits: 0
						ignoreActors:
						posn: (+ (gEgo x:) 8) (- (gEgo y:) 5)
						setPri: 2
					)
					(gEgo setScript: egoIsDying)
				else
					(gEgo setScript: egoIsDying)
				)
			)
			(8
				(HandsOff)
				(= local101 2)
				(hijacker1Timer dispose: delete:)
				(hijacker2Timer dispose: delete:)
				(global200
					view: 84
					loop: 1
					cel: 0
					setPri: (+ (global200 priority:) 1)
					setCycle: End self
				)
			)
			(9
				(global200 setPri: 2)
				(hijacker2Timer setReal: self 3)
			)
			(10
				(proc154_1 41 40)
				(proc154_1 41 41)
				(SetScore 3)
				(gContinuousMusic number: 25 loop: -1 play:)
				(client setScript: 0)
				(gCurRoom setScript: intoCockpit)
			)
		)
	)
)

(instance intoCockpit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(HandsOff)
				(= local101 0)
				(if global204
					(= global204 0)
					(gEgo
						view: 4
						loop: (mod (gEgo loop:) 4)
						setCel: 255
						setCycle: Beg self
					)
				else
					(self cue:)
				)
			)
			(2
				(gEgo view: 0)
				(proc154_1 41 42)
				(proc154_1 41 43)
				(= seconds 2)
			)
			(3
				(global198
					view: 84
					loop: 4
					cel: 0
					posn: 251 76
					setCycle: End self
				)
			)
			(4
				(global198
					view: 26
					loop: 1
					setCel: 0
					ignoreActors:
					illegalBits: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 238 66 self
				)
			)
			(5
				(proc154_1 41 44)
				(= seconds 2)
			)
			(6
				(global198 setMotion: MoveTo 268 55 self)
			)
			(7
				(local104 setPri: 0 setCycle: End self)
			)
			(8
				(local104 stopUpd:)
				(global198 setPri: 0 setMotion: MoveTo 275 50 self)
			)
			(9
				(global198 hide:)
				(local104 setCycle: Beg)
				(global112 setCycle: Beg self)
			)
			(10
				(global112
					view: 20
					loop: 0
					setPri: 2
					cycleSpeed: 0
					posn: 223 57
					ignoreActors:
					illegalBits: 0
					setCycle: Walk
				)
				(RedrawCast)
				(proc154_1 41 45)
				(proc154_1 41 46)
				(= seconds 1)
			)
			(11
				(global112 setMotion: MoveTo 265 58 self)
			)
			(12
				(local104 setCycle: End self)
			)
			(13
				(local104 stopUpd:)
				(global112 setPri: 0 setMotion: MoveTo 275 50 self)
			)
			(14
				(global112 hide:)
				(local104 setCycle: Beg self)
			)
			(15
				(HandsOn)
				(gCurRoom newRoom: 42)
			)
		)
	)
)

