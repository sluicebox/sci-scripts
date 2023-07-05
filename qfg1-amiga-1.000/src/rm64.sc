;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use LoadMany)
(use Rev)
(use Follow)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm64 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(EgoDead 64 0 80 { Oh-h-h-h-h-h-h! } 70 250 82 516 0 0) ; "As the ghosts suck the life out of your body, and you crumple into the dust of the old graveyard, you think unspeakable thoughts of torture and torment directed at programmers, game designers, and vicious artists named Kenn."
)

(instance riser of Act
	(properties)
)

(instance longOne of Act
	(properties)
)

(instance mandrake of View
	(properties
		y 122
		x 130
		view 63
		loop 3
	)
)

(instance etching of PV
	(properties
		y 133
		x 227
		view 63
	)
)

(instance gravestone of PV
	(properties
		y 119
		x 124
		view 63
		loop 2
		priority 6
	)
)

(instance rm64 of Rm
	(properties
		picture 64
		style 8
		horizon 116
		north 52
		west 63
	)

	(method (dispose)
		(DisposeScript riseUpLeft)
		(DisposeScript riseUpRight)
		(DisposeScript riseDownLeft)
		(DisposeScript peekABoo)
		(if gNight
			(= global325 (SoundFX 26))
			(SetFlag 114)
		else
			(SetFlag 54)
		)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsSCRIPT 805 806)
		(LoadMany rsVIEW 64 63 516)
		(super init:)
		(SL enable:)
		(gContMusic fade:)
		(self setRegions: 806) ; Cemetery
		(gAddToPics add: etching gravestone eachElementDo: #init doit:)
		(if (and (not (gEgo has: 4)) (< (+ global277 1) gDay)) ; mandrake
			(mandrake setPri: 8 stopUpd: init:)
		)
		(if gNight
			(= global325 37)
			(riser
				view: 64
				setLoop: 3
				ignoreActors:
				ignoreHorizon:
				illegalBits: 0
				posn: 0 1000
				init:
				cycleSpeed: 1
				stopUpd:
			)
			(longOne
				view: 64
				setLoop: 7
				setPri: 6
				ignoreActors:
				ignoreHorizon:
				illegalBits: 0
				posn: 21 126
				init:
				setStep: 3 1
				cycleSpeed: 1
				setCycle: Fwd
				stopUpd:
			)
			((ScriptID 805 5) init:) ; twister
			((ScriptID 805 6) init:) ; tumbler
			((ScriptID 805 7) init:) ; swimmer
			(ghostMusic init: play:)
		)
		(= global320 0)
		(= local1 (Random 0 7))
		(NormalEgo)
		(gEgo init:)
		(if (and gNight (IsFlag 168))
			(SolvePuzzle 682 2)
		)
		(switch gPrevRoomNum
			(72
				(gEgo posn: 160 188 setMotion: MoveTo 160 180)
				(self setScript: safeIntro)
			)
			(52
				(gEgo posn: 160 117 setMotion: MoveTo 160 125)
				(self setScript: safeIntro)
			)
			(else
				(gEgo posn: 1 172 setMotion: MoveTo 25 172)
				(self setScript: safeIntro)
			)
		)
	)

	(method (doit)
		(if (and (== (gEgo edgeHit:) 3) (not local3))
			(gCurRoom newRoom: 72)
		)
		(if (and (not local3) (== (gEgo onControl: 1) 16384))
			(= local3 1)
			(self setScript: fallInHole)
		)
		(cond
			(
				(and
					(< 68 (gEgo x:) 270)
					(< 120 (gEgo y:) 160)
					(not local2)
					(not (IsFlag 168))
					(not (IsFlag 164))
					gNight
				)
				(SetFlag 164)
			)
			(
				(and
					(IsFlag 164)
					(not local2)
					(or
						(< (gEgo distanceTo: riser) 35)
						(< (gEgo distanceTo: (ScriptID 805 5)) 35) ; twister
						(< (gEgo distanceTo: (ScriptID 805 7)) 35) ; swimmer
						(< (gEgo distanceTo: (ScriptID 805 6)) 35) ; tumbler
						(< (gEgo distanceTo: longOne) 35)
					)
				)
				(= local2 1)
				(ClearFlag 164)
				(self setScript: gotHim)
			)
		)
		(if (and gNight (< global320 3))
			(switch local1
				(0
					(if (== ((ScriptID 805 7) script:) 0) ; swimmer
						(++ global320)
						(++ local1)
						((ScriptID 805 7) setScript: (ScriptID 805 3)) ; swimmer, swimRight
					)
				)
				(1
					(if (== (riser script:) 0)
						(++ global320)
						(++ local1)
						(riser setScript: riseUpRight)
					)
				)
				(2
					(if (== ((ScriptID 805 6) script:) 0) ; tumbler
						(++ global320)
						(++ local1)
						((ScriptID 805 6) setScript: (ScriptID 805 2)) ; tumbler, spinOnTree
					)
				)
				(3
					(if (== ((ScriptID 805 7) script:) 0) ; swimmer
						(++ global320)
						(++ local1)
						((ScriptID 805 7) setScript: (ScriptID 805 4)) ; swimmer, swimLeft
					)
				)
				(4
					(if (== ((ScriptID 805 5) script:) 0) ; twister
						(++ global320)
						(++ local1)
						((ScriptID 805 5) setScript: (ScriptID 805 0)) ; twister, twistIt
					)
				)
				(5
					(if (== (longOne script:) 0)
						(++ global320)
						(++ local1)
						(longOne setScript: peekABoo)
					)
				)
				(6
					(if (== (riser script:) 0)
						(++ global320)
						(++ local1)
						(riser setScript: riseUpLeft)
					)
				)
				(7
					(if (== ((ScriptID 805 6) script:) 0) ; tumbler
						(++ global320)
						(++ local1)
						((ScriptID 805 6) setScript: (ScriptID 805 1)) ; tumbler, spinAcross
					)
				)
				(8
					(if (== (riser script:) 0)
						(= local1 0)
						(++ global320)
						(riser setScript: riseDownLeft)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'climb,climb[/wall]')
						(if gNight
							(if (> (gEgo x:) 256)
								(if (TrySkill 11 35 0) ; climbing
									(gCurRoom newRoom: 330)
								else
									(HighPrint 64 1) ; "The wall is too difficult for your level of skill, but keep practicing."
								)
							else
								(HighPrint 64 2) ; "You're not in a good spot for climbing the wall."
							)
						else
							(HighPrint 64 3) ; "You would have trouble convincing people you are a Hero if you climbed the wall into town during the day."
						)
					)
					((Said 'look,read/brick,marker,gravestone,epitaph[<grave]')
						(cond
							((gEgo inRect: 130 113 168 140)
								(HighPrint 64 4) ; "The large tombstone seems to have a barely legible epitaph:"
								(HighPrint 64 5) ; "Here lies an atheist..."
								(HighPrint 64 6) ; "All dressed up and nowhere to go."
								(HighPrint 64 7) ; "Growing up out of the grave is an evil-looking plant with a slimy, poisonous sheen."
							)
							(
								(and
									(or
										(== (gEgo loop:) 2)
										(== (gEgo loop:) 6)
									)
									(gEgo inRect: 28 168 112 189)
								)
								(HighPrint 64 8) ; "The large stone you are facing has been engraved with this message:"
								(HighPrint 64 9) ; "Here lies Lester Moore Gored six times by a wild boar."
								(HighPrint 64 10) ; "No Les, no Moore."
							)
							(else
								(HighPrint 64 11) ; "The carving on the gravestones, for the most part, seems to have been intentionally defaced and worn with time."
							)
						)
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(if gNight
										(HighPrint 64 12) ; "You sense what nobody needed to tell you: SOMETHING is making those spirits fly around, and it isn't the wind."
									else
										(HighPrint 64 13) ; "You sense a spiritual coldness."
									)
								)
								(17
									(HighPrint 64 14) ; "The only things that can be opened here are graves, and you don't want to open THOSE!"
								)
								(else
									(HighPrint 64 15) ; "Your magical abilities are to no avail against the undead."
								)
							)
						)
					)
					((Said 'look>')
						(cond
							(
								(or
									(Said '<down')
									(Said '/ground,chasm,grave,pit')
								)
								(if (gEgo inRect: 204 144 267 167)
									(HighPrint 64 16) ; "You can't see the bottom of the hole before you."
								else
									(HighPrint 64 17) ; "Nothing grows in the dirt of the old graveyard. Some of the graves appear to have been disturbed."
								)
							)
							((Said '/ghost,ghoul')
								(if gNight
									(switch (Random 0 1)
										(0
											(HighPrint 64 18) ; "You see transparent, decaying, writhing, slimy, undead fragments of undulating ectoplasm!"
										)
										(1
											(HighPrint 64 19) ; "I DO believe in spooks! I DO believe in spooks! I DO, I DO, I DO believe in spooks!!"
										)
									)
								else
									(HighPrint 64 20) ; "You recall from somewhere that the most likely time to find ghosts is at night."
								)
							)
							((Said '/grave')
								(HighPrint 64 21) ; "The graves seemed to be placed haphazardly in the tiny graveyard. All appear to be old and poorly maintained."
							)
							((Said '/wall')
								(HighPrint 64 22) ; "The town wall looks more massive from this side."
							)
							((Said '/tree')
								(HighPrint 64 23) ; "There is a very large and very dead tree which hovers over the graveyard."
								(HighPrint 64 24) ; "The forest surrounds the graveyard on three sides."
							)
							((Said '/fence')
								(HighPrint 64 25) ; "You see the rotted remains of a picket fence."
							)
							((Said '/ladder')
								(HighPrint 64 26) ; "What at first appears to be a ladder turns out to be the rotted remains of a picket fence."
							)
							((Said '/root,mandrake,plant')
								(cond
									((gEgo has: 4) ; mandrake
										(HighPrint 64 27) ; "Let's see...root..root... I know I put that root SOMEwhere!"
									)
									(
										(and
											(gEgo inRect: 130 113 168 140)
											(< (+ global277 1) gDay)
										)
										(HighPrint 64 7) ; "Growing up out of the grave is an evil-looking plant with a slimy, poisonous sheen."
									)
									(else
										(HighPrint 64 28) ; "You don't see it."
									)
								)
							)
							((Said '[<at,around][/!*,cemetery,cemetery]')
								(if gNight
									(HighPrint 64 29) ; "It appears that the spirits frolic here during the dark hours."
								else
									(HighPrint 64 30) ; "It's certainly creepy here even during the daylight hours."
								)
							)
						)
					)
					((Said 'kill')
						(HighPrint 64 31) ; "Everything here is already dead."
					)
					((Said 'get>')
						(cond
							((Said '/ghost')
								(HighPrint 64 32) ; "You don't get ghosts. Ghosts get YOU!"
							)
							((Said '/mandrake,root,plant')
								(cond
									((gEgo has: 4) ; mandrake
										(AlreadyDone)
									)
									(
										(and
											(gEgo inRect: 130 113 168 140)
											(< (+ global277 1) gDay)
										)
										(gEgo setScript: getRoot)
									)
									(else
										(HighPrint 64 33) ; "You haven't found it yet."
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance riseDownLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(riser
					posn: -65 105
					setCycle: Fwd
					setLoop: 5
					setPri: 10
					setStep: 6 4
				)
				(if (IsFlag 164)
					(riser
						z: 25
						posn: (riser x:) (+ (riser y:) 25)
						setMotion: Follow gEgo 30
					)
				else
					(riser setMotion: MoveTo 255 117 self)
				)
			)
			(1
				(riser
					posn: (- (riser x:) 47) (+ (riser y:) 17)
					setStep: 3 2
					setLoop: 3
					cel: 4
					setMotion: MoveTo 240 150
					setCycle: Beg self
				)
			)
			(2
				(riser setCel: 0 setMotion: MoveTo 240 205 self)
			)
			(3
				(-- global320)
				(riser stopUpd: setScript: 0)
			)
		)
	)
)

(instance riseUpLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(riser
					posn: 230 205
					setStep: 3 2
					setPri: 10
					setLoop: 4
					setCel: 0
					setMotion: MoveTo 230 150 self
				)
			)
			(1
				(riser setMotion: MoveTo 230 134 setCycle: End self)
			)
			(2
				(riser
					posn: (- (riser x:) 47) (- (riser y:) 17)
					setCycle: Fwd
					setLoop: 6
					setPri: 9
					setStep: 6 4
				)
				(if (IsFlag 164)
					(riser
						z: 25
						posn: (riser x:) (+ (riser y:) 25)
						setMotion: Follow gEgo 30
					)
				else
					(riser setMotion: MoveTo -65 (Random 45 115) self)
				)
			)
			(3
				(-- global320)
				(riser stopUpd: setScript: 0)
			)
		)
	)
)

(instance riseUpRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(riser
					posn: 240 205
					setStep: 3 2
					setPri: 10
					setLoop: 3
					setCel: 0
					setMotion: MoveTo 240 150 self
				)
			)
			(1
				(riser setMotion: MoveTo 240 134 setCycle: End self)
			)
			(2
				(riser
					posn: (+ (riser x:) 47) (- (riser y:) 17)
					setCycle: Fwd
					setLoop: 5
					setStep: 6 4
					setMotion: MoveTo 320 -27 self
				)
			)
			(3
				(-- global320)
				(riser stopUpd: setScript: 0)
			)
		)
	)
)

(instance peekABoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(longOne startUpd: setCycle: Fwd)
				(if (IsFlag 164)
					(longOne setMotion: Follow gEgo 30)
				else
					(longOne setMotion: MoveTo 21 70 self)
				)
			)
			(1
				(++ local0)
				(longOne setCycle: Rev setMotion: MoveTo 21 50 self)
			)
			(2
				(if (> local0 2)
					(longOne setMotion: MoveTo 21 126 self)
				else
					(self changeState: 0)
				)
			)
			(3
				(-- global320)
				(longOne stopUpd: setScript: 0)
			)
		)
	)
)

(instance getHimNorth of Script ; UNUSED
	(properties)

	(method (doit)
		(if
			(and
				(or
					(< (gEgo distanceTo: riser) 25)
					(< (gEgo distanceTo: (ScriptID 805 5)) 25) ; twister
					(< (gEgo distanceTo: (ScriptID 805 6)) 25) ; tumbler
				)
				(not local2)
			)
			(= local2 1)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(riser
					z: 35
					setPri: 14
					setLoop: 5
					posn: 52 116
					setCycle: Fwd
					setMotion: Follow gEgo 20
				)
				((ScriptID 805 5) ; twister
					view: 64
					setLoop: 0
					setPri: 14
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 163 0
					init:
					cycleSpeed: 1
					setCycle: Fwd
					setStep: 3 3
					setMotion: Follow gEgo 20
				)
				((ScriptID 805 6) ; tumbler
					view: 64
					setLoop: 8
					setPri: 7
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 251 39
					init:
					setCycle: Fwd
					setStep: 3 2
					setMotion: Follow gEgo 20
				)
				(= cycles 5)
			)
			(1
				(if (not (IsFlag 114))
					(HighPrint 64 34) ; "It appears that you have company in the graveyard tonight."
				)
			)
			(2
				(HandsOff)
				(riser setMotion: Follow gEgo 5)
				((ScriptID 805 5) setMotion: Follow gEgo 5) ; twister
				((ScriptID 805 6) setMotion: Follow gEgo 5) ; tumbler
				(= cycles 15)
			)
			(3
				(gEgo view: 516 setLoop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(localproc_0)
			)
		)
	)
)

(instance getHimSouth of Script ; UNUSED
	(properties)

	(method (doit)
		(if
			(and
				(or
					(< (gEgo distanceTo: riser) 25)
					(< (gEgo distanceTo: (ScriptID 805 7)) 25) ; swimmer
					(< (gEgo distanceTo: longOne) 25)
				)
				(not local2)
			)
			(= local2 1)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(riser setScript: riserGetsUp)
				(longOne
					setPri: 14
					posn: 59 221
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: Follow gEgo 5
				)
				((ScriptID 805 7) ; swimmer
					view: 64
					setPri: 14
					setLoop: 1
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 27 53
					init:
					cycleSpeed: 1
					setCycle: Fwd
					setStep: 3 2
					setMotion: Follow gEgo 5
				)
				(= cycles 5)
			)
			(1
				(if (not (IsFlag 114))
					(HighPrint 64 34) ; "It appears that you have company in the graveyard tonight."
				)
			)
			(2
				(HandsOff)
				(= cycles 15)
			)
			(3
				(gEgo view: 516 setLoop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(localproc_0)
			)
		)
	)
)

(instance riserGetsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(riser
					setLoop: 4
					setCel: 0
					setPri: 11
					posn: 234 203
					setMotion: MoveTo 234 163 self
				)
			)
			(1
				(riser setCel: -1 setCycle: End self)
			)
			(2
				(riser
					z: 35
					posn: (- (riser x:) 47) (+ (riser y:) 8)
					setPri: 14
					setLoop: 6
					setCycle: Fwd
					setMotion: Follow gEgo 5
				)
			)
		)
	)
)

(instance gotHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(riser
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				((ScriptID 805 5) ; twister
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				((ScriptID 805 7) ; swimmer
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				((ScriptID 805 6) ; tumbler
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				(longOne
					setPri: (+ (gEgo priority:) 1)
					setMotion: Follow gEgo 10
				)
				(= cycles 15)
			)
			(1
				(gEgo view: 516 setLoop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(localproc_0)
			)
		)
	)
)

(instance safeIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(and gNight (IsFlag 114))
						(and (not gNight) (IsFlag 54))
					)
					(client setScript: 0)
				else
					(= cycles 8)
				)
			)
			(1
				(HighPrint 64 35) ; "This must be the town graveyard. What a run-down place!"
				(if gNight
					(HighPrint 64 29) ; "It appears that the spirits frolic here during the dark hours."
				else
					(HighPrint 64 30) ; "It's certainly creepy here even during the daylight hours."
				)
				(client setScript: 0)
			)
		)
	)
)

(instance fallInHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					setLoop: (gEgo loop:)
					setPri: 10
					setStep: 3 12
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 230 self
				)
			)
			(1
				(EgoDead 64 36 82 507 5 1 80 { Watch your step! }) ; "You stepped into a hole whose depth is unfathomable. As you fall ever downward, you feel icy fingers clutching at you, and you think: "How could I be so careless?""
			)
		)
	)
)

(instance getRoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 130 126 self
				)
			)
			(1
				(gEgo setLoop: 3)
				(mandrake dispose:)
				(= cycles 2)
			)
			(2
				(if (== gTimeOfDay 6)
					(HighPrint 64 37) ; "You wrench the mandrake plant free from the tombstone on which it has grown. You hear a scream like that of a dying child as you yank the root from the ground."
					(SolvePuzzle 683 6)
					(gEgo get: 4) ; mandrake
				else
					(HighPrint 64 38) ; "You wrench the mandrake plant free from the tombstone on which it has grown. Somehow you thought this would be a lot harder. You wonder if you did this right."
					(HighPrint 64 39) ; "The root shrivels and twists in your hands until nothing is left. Astonished, you look at your empty hands."
					(= global277 gDay)
				)
				(gEgo setMotion: MoveTo 130 130 self)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance ghostMusic of Sound
	(properties
		number 12
		loop -1
	)
)

