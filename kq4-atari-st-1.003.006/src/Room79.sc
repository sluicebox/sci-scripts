;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room79 0
)

(synonyms
	(goon goon goon man goon goon animal goon)
)

(local
	local0
	local1
	local2
)

(instance henchTheme of Sound
	(properties
		number 29
		loop -1
	)
)

(instance sFalling of Sound
	(properties
		number 51
		priority 3
	)
)

(instance Room79 of Rm
	(properties
		picture 79
		style 8
	)

	(method (init)
		(= east 80)
		(= west 30)
		(= north 80)
		(= south 30)
		(= gIndoors 0)
		(Load rsVIEW 80)
		(Load rsVIEW 60)
		(Load rsVIEW 140)
		(Load rsVIEW 142)
		(Load rsVIEW 143)
		(Load rsVIEW 144)
		(if gNight
			(= picture 179)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo view: 2 posn: 232 91 loop: 1 init:)
			)
			(west
				(if global169
					(= local0 (Act new:))
					(= local1 (Act new:))
					(local0 setScript: h1Actions)
					(local1 setScript: h2Actions init: hide:)
				)
				(gEgo x: 63 y: 188)
				(gEgo init: view: 2)
			)
			(else
				(gEgo x: 63 y: 188)
				(= local0 (Act new:))
				(= local1 (Act new:))
				(local0 setScript: h1Actions)
				(local1 setScript: h2Actions init: hide:)
				(gEgo x: 63 y: 188)
				(gEgo init: view: 2)
			)
		)
		(gEgo edgeHit: EDGE_NONE)
		(= global105 0)
		(= global189 1)
		(= global204 0)
	)

	(method (newRoom newRoomNumber)
		(cls)
		(if (!= global105 10)
			(= global189 0)
			(gEgo illegalBits: -32768 setPri: -1)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== (gCurRoom script:) 0) (== global105 0))
			(cond
				((& (= temp0 (gEgo onControl: 0)) $0040)
					(gCurRoom newRoom: 80)
				)
				((& temp0 $0010)
					(if (< (gEgo heading:) 180)
						(gEgo baseSetter: 0)
					else
						(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
					)
				)
				((& temp0 $0f8e)
					(gSounds eachElementDo: #stop 0)
					(sFalling play:)
					(stopHench cue:)
					(gCurRoom
						setScript:
							(cond
								((& temp0 $0002) fallBlue)
								((& temp0 $0008) fallCyan)
								((& temp0 $0004) fallGreen)
								((& temp0 $0080) fallLgrey)
								((& temp0 $0100) fallGrey)
								((& temp0 $0200) fallLblue)
								((& temp0 $0400) fallLgreen)
								((& temp0 $0800) fallLcyan)
							)
					)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((or (Said '/room,cliff') (Said '[<around][/!*]'))
							(Print 79 0) ; "The treacherous path winds narrowly around the craggy mountain. In the distance, perched upon a rocky ledge, you see a dark, unfriendly castle."
						)
						((Said '/goon')
							(if (gCast contains: local0)
								(Print 79 1) ; "Lolotte's goons are not appealing at all! Besides having an unnatural pallor to their skin, they are creepy little creatures who fly upon wings that resemble those of bats."
							else
								(Print 79 2) ; "You don't see one here."
							)
						)
						((Said '/path')
							(Print 79 3) ; "The mountain path is thin and dangerous. It seems to lead to the dark castle."
						)
						((Said '/castle')
							(Print 79 4) ; "The dark castle looks very forbidding. It perches precariously upon an over-hanging, mountain ledge. The path, upon which you are now treading, seems to lead directly to the sinister castle."
						)
						((Said '/boulder')
							(Print 79 5) ; "The whole mountain is rocky."
						)
						((Said '/dirt,down')
							(Print 79 6) ; "The ground is a long way down."
						)
						((Said '/forest')
							(Print 79 7) ; "You see a forest of trees below you."
						)
					)
				)
				((Said 'climb/cliff')
					(Print 79 8) ; "The craggy mountains are much too steep to climb."
				)
				((or (Said 'talk/goon') (Said 'talk[/!*]'))
					(Print 79 9) ; "Lolotte's henchmen must not speak, as they only utter strange guttural sounds."
				)
				((Said 'get,capture/goon')
					(Print 79 10) ; "Why would you want one?!"
				)
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 79 11) ; "The henchmen are not interested in your offering."
						else
							(Print 800 2) ; "You don't have it."
						)
					else
						(Print 79 12) ; "You can't give that."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance fallBlue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global105 10)
				(HandsOff)
				(gEgo
					setPri: 8
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (- (gEgo x:) 8) (gEgo y:)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallCyan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 8
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (+ (gEgo y:) 8)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 4
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (- (gEgo y:) 8)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallLgrey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 10
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (+ (gEgo x:) 8) (+ (gEgo y:) 4)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallGrey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 7
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (+ (gEgo y:) 4)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallLblue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 6
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (+ (gEgo y:) 4)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallLgreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 0
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (- (gEgo y:) 4)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance fallLcyan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					setPri: 0
					yStep: 10
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (+ (gEgo y:) 4)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 150) self
				)
			)
			(1
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance h1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(henchTheme play:)
				(local0
					ignoreHorizon:
					posn: 57 6
					setStep: 4 3
					view: 142
					setCycle: Walk
					setMotion: MoveTo -10 22 self
					ignoreActors:
					illegalBits: 0
					setPri: 13
					init:
				)
				(Print 79 13 #draw #at -1 20 #dispose) ; "Oh, oh! Lolotte's goons!"
			)
			(1
				(local0 xStep: 4 yStep: 3 setMotion: MoveTo -10 50 self)
			)
			(2
				(cls)
				(local0
					view: 143
					xStep: 6
					yStep: 4
					setMotion: MoveTo 252 66 self
				)
			)
			(3
				(local0
					view: 144
					xStep: 8
					yStep: 6
					setMotion: Chase gEgo 14 self
				)
				(h2Actions changeState: 1)
			)
			(4
				(local0 view: 140 posn: (+ (gEgo x:) 14) (+ (gEgo y:) 5))
				(LookAt local0 gEgo)
				(gEgo loop: 0 setMotion: 0)
				(HandsOff)
			)
		)
	)
)

(instance h2Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local1
					ignoreHorizon:
					posn: 57 6
					view: 142
					setCycle: Walk
					xStep: 4
					yStep: 3
					setMotion: MoveTo 26 65 self
					ignoreActors:
					illegalBits: 0
					setPri: 13
					show:
				)
			)
			(2
				(local1
					view: 143
					xStep: 6
					yStep: 4
					setMotion: MoveTo 42 120 self
				)
			)
			(3
				(local1
					view: 144
					xStep: 8
					yStep: 6
					setMotion: MoveTo (- (gEgo x:) 14) (gEgo y:) self
				)
			)
			(4
				(local1 view: 140)
				(LookAt local1 gEgo)
				((ScriptID 0 4) setReal: self 2) ; timer1
			)
			(5
				(= global105 1)
				(local0 hide:)
				(local1 hide:)
				(cond
					((== gAct 1)
						(self changeState: 20)
					)
					((and (== gAct 2) (not (gEgo has: 33))) ; Magic_Hen
						(self changeState: 20)
					)
					((and (== gAct 3) (not (gEgo has: 4))) ; Pandora_s_Box
						(self changeState: 20)
					)
					(else
						(gEgo
							view: 60
							illegalBits: 0
							setPri: 15
							ignoreHorizon:
							setLoop: 1
							cel: 0
							setCycle: End self
						)
					)
				)
			)
			(6
				(gEgo
					view: 80
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 24 60 self
				)
			)
			(7
				(gEgo
					setLoop: 3
					posn: (gEgo x:) (- (gEgo y:) 5)
					setMotion: MoveTo 50 38
				)
				((ScriptID 0 4) setReal: self 2) ; timer1
			)
			(8
				(gEgo setLoop: 1 setMotion: MoveTo 72 29)
				((ScriptID 0 4) setReal: self 3) ; timer1
			)
			(9
				(gEgo
					illegalBits: 0
					setPri: 15
					setLoop: 0
					setMotion: MoveTo 72 29 self
				)
			)
			(10
				(gEgo setLoop: -1 setCel: -1)
				(User canControl: 1)
				(User canInput: 1)
				(gEgo dispose:)
				(HandsOn)
				(gCurRoom newRoom: 92)
			)
			(20
				(gEgo
					illegalBits: 0
					setPri: 15
					view: 60
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(21
				(SoundLoops henchTheme 1)
				(gEgo
					view: 80
					setCycle: Fwd
					setLoop: 4
					setMotion: MoveTo -40 160 self
				)
			)
			(22
				(HandsOn)
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance egoDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 3)
			)
			(1
				(Print 79 14) ; "You should be more careful, Rosella!"
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(2
				(= gDeathFlag 1)
			)
		)
	)
)

(instance stopHench of Script
	(properties)

	(method (cue)
		(if (gCast contains: local0)
			(local0
				setLoop: -1
				setCycle: Walk
				setMotion: MoveTo -68 32
				setCycle: Fwd
			)
		)
		(if (gCast contains: local1)
			(local1
				setLoop: -1
				setCycle: Walk
				setMotion: MoveTo -68 32
				setCycle: Fwd
			)
		)
	)
)

