;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use TargActor)
(use Interface)
(use getUpS)
(use VerbMessager)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm260 0
	ChainScripts 1
)

(local
	oldVerbMsgr
	kareemState
	abdulState
	jabbarState
	thisControl
	lastDifX
	lastDifY
	ignoreNoise
	catchHim
	hiding
	chestOpen
	stoleMoney
	stealthy
	checkStealth = 6
	notHeardVoice = 1
	trapMsg
	jabbarWait = 4
	gaitCnt = 10
	[windowParams 18] = [{Old Man:} 0 7 {Kareem:} 15 4 {Abdul:} 15 3 {Jabbar:} 11 1 {Kamar:} 14 6 {Baddhi Slama:} 9 0]
)

(procedure (WhoPrint who &tmp thisWin thisTitle)
	(= thisWin (= thisTitle (* who 3)))
	(myWindow color: [windowParams (++ thisWin)] back: [windowParams (++ thisWin)])
	(Print &rest #title [windowParams thisTitle] #window myWindow)
)

(procedure (HuhPrint)
	(WhoPrint
		0
		(switch (Random 0 2)
			(0 {Huh.  Must've been my imagination again.})
			(1 {Huh.  I'm hearing things again, I guess.})
			(2 {Huh.  Kamar, your father is becoming senile.})
		)
	)
	(WhoPrint 4 {Yes, Father.})
)

(procedure (ChainScripts nextScript)
	(cond
		((== hiding 4)
			((ScriptID 261 4) next: nextScript) ; getOutS
			(gEgo setScript: (ScriptID 261 4)) ; getOutS
		)
		((== hiding 2)
			((ScriptID 261 1) next: nextScript) ; getUpS
			(gEgo setScript: (ScriptID 261 1)) ; getUpS
		)
		(else
			(gEgo setScript: nextScript)
		)
	)
)

(procedure (MADENOISE)
	(if
		(and
			(not (gEgo isStopped:))
			(not (-- gaitCnt))
			(= gaitCnt 8)
			(not ignoreNoise)
			(or
				(not stealthy)
				(!= gEgoGait 2) ; sneaking
				(and (& thisControl $0080) (LowPrint 260 99) (gEgo setMotion: 0)) ; "squeeeeek!"
			)
		)
		(= gaitCnt 1)
	)
)

(procedure (CheckChest)
	(if chestOpen
		(HighPrint 260 100) ; "You see the heavy chest, its lid still open."
	else
		(HighPrint 260 101) ; "You see a heavy, locked chest concealed beneath the floorboards."
	)
)

(procedure (MovingToWardrobe &tmp result newDifX newDifY)
	(= result
		(if (gEgo mover:)
			(and
				(<= (= newDifX (Abs (- 163 (gEgo x:)))) lastDifX)
				(<= (= newDifY (Abs (- 103 (gEgo y:)))) lastDifY)
			)
		)
	)
	(= lastDifX newDifX)
	(= lastDifY newDifY)
	(return result)
)

(instance rm260 of Rm
	(properties
		picture 260
		style 9
	)

	(method (notify val)
		(if argc
			(= hiding val)
		else
			(return hiding)
		)
	)

	(method (init)
		(= oldVerbMsgr (User verbMessager:))
		(User verbMessager: myVerbs)
		(LoadMany rsVIEW 1 2 47 260 261 294 358)
		(LoadMany rsSCRIPT 261)
		(Load rsSOUND 260)
		(SolvePuzzle 701 3 2)
		(gCSound number: 260 loop: -1 priority: 0 playBed:)
		(NormalEgo)
		(super init:)
		(initRugs)
		(pots init: stopUpd:)
		(trapdoor init:)
		(door init:)
		(rugRoll init: stopUpd:)
		(drapes init: stopUpd:)
		(gEgo init: hide: setScript: enterRoomS)
		(CantBePaladin)
		(= gSpellChecker gAllChecker)
	)

	(method (dispose)
		(gCSound stop:)
		(DisposeScript 261)
		(super dispose:)
	)

	(method (doit &tmp stealthNeeded)
		(cond
			(
				(and
					(& (= thisControl (gEgo onControl: 1)) $2000)
					(not (gEgo script:))
				)
				(gEgo setScript: exitRoomS)
			)
			((and (& thisControl $0002) (not script))
				(LowPrint 260 0) ; "SQUEEEEEEK!!"
				(WhoPrint 0 260 1) ; "Did you here that noise, Kamar? See what it might be!"
				(if jabbarState
					(beingRobbedS start: 7)
				else
					(beingRobbedS start: 1)
					(= gEgoGait 1) ; running
					(= catchHim 1)
					(NormalEgo)
				)
				(gCurRoom setScript: beingRobbedS)
			)
			((and (not script) (not (gEgo script:)) (MADENOISE))
				(self setScript: isatUKamar)
			)
			(ignoreNoise
				(-- ignoreNoise)
			)
			((and checkStealth (not (or script (gEgo script:) (-- checkStealth))))
				(= stealthNeeded
					(+ (Random 0 10) (- 90 (/ (gEgo distanceTo: drapes) 3)))
				)
				(= stealthy (TrySkill 8 stealthNeeded)) ; sneak
				(= checkStealth 72)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [str 10])
		(cond
			((super handleEvent: event))
			(
				(and
					(not script)
					(not ignoreNoise)
					(not stealthy)
					(not hiding)
					(Said 'say,talk,talk,yell')
				)
				(self setScript: isatUKamar)
			)
			((Said 'look,look[<at,around][/room,area][/!*]')
				(if (== hiding 4)
					(HighPrint 260 2) ; "You can't see anything in the dark wardrobe."
				else
					(HighPrint 260 3) ; "You are in the front room of a modestly appointed house. It is sparsely furnished."
				)
			)
			((Said 'look,look/shelf')
				(HighPrint 260 4) ; "The pots on the shelf are pretty, but pretty worthless."
				(if (not (IsFlag 57))
					(HighPrint 260 5) ; "There is, however, a silver tea service on the top shelf which looks valuable."
				)
			)
			((Said 'search,look,look[/room,floor]')
				(cond
					((and (trapdoor cel:) (rugRoll cel:))
						(HighPrint 260 6) ; "You see an open trapdoor."
					)
					((rugRoll cel:)
						(HighPrint 260 7) ; "You see a trapdoor concealed in the floor."
					)
					(else
						(HighPrint 260 8) ; "That is a good idea. You should do that."
						(Print 260 9) ; "Definitely."
					)
				)
			)
			((Said '(roll[<up]),search,(look,look<below)/carpet[<up]')
				(cond
					((< (gEgo x:) 63)
						(HighPrint 260 10) ; "The small carpet is firmly attached to the floor."
					)
					((rugRoll cel:)
						(HighPrint 260 11) ; "You have already rolled up the carpet."
					)
					(else
						(ChainScripts rollRugS)
					)
				)
			)
			((Said '(roll[<back]),unroll,replace/carpet[<back]')
				(cond
					((< (gEgo x:) 63)
						(HighPrint 260 10) ; "The small carpet is firmly attached to the floor."
					)
					((rugRoll cel:)
						(ChainScripts unrollRugS)
					)
					(else
						(HighPrint 260 12) ; "You have to roll it up before you can unroll it."
					)
				)
			)
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
					(Said 'unlock/chest,lock,lid')
				)
				(cond
					((or (not (rugRoll cel:)) (not (trapdoor cel:)))
						(HighPrint 260 13) ; "You can't seem to find a lock to pick."
					)
					(chestOpen
						(HighPrint 260 14) ; "You have already opened the locked chest."
					)
					((not (CanPickLocks 1)))
					(else
						(bendOverS register: 2)
						(ChainScripts bendOverS)
					)
				)
			)
			((Said 'close,close/chest,lid,trunk')
				(cond
					((or (not (rugRoll cel:)) (not (trapdoor cel:)))
						(HighPrint 260 15) ; "You don't see anything to close."
					)
					((not chestOpen)
						(HighPrint 260 16) ; "The chest is already closed."
					)
					(else
						(bendOverS register: 3)
						(ChainScripts bendOverS)
					)
				)
			)
			((Said 'open,open/chest')
				(cond
					((or (not (rugRoll cel:)) (not (trapdoor cel:)))
						(HighPrint 260 17) ; "You don't see anything to open."
					)
					(chestOpen
						(HighPrint 260 18) ; "The chest is already open."
					)
					(else
						(HighPrint 260 19) ; "The chest is locked."
					)
				)
			)
			((Said 'get,get/chest')
				(if (or (not (rugRoll cel:)) (not (trapdoor cel:)))
					(HighPrint 260 20) ; "You don't see any chest here."
				else
					(HighPrint 260 21) ; "The chest is far too heavy to lift out of this hole."
				)
			)
			((Said 'get,get,get,grab/dinar,alm')
				(cond
					(stoleMoney
						(HighPrint 260 22) ; "You've already taken all the dinars."
					)
					((== abdulState 1)
						(abdulS cycles: 0 seconds: 0 changeState: 7)
						(= catchHim 1)
					)
					((and (rugRoll cel:) (trapdoor cel:) chestOpen)
						(bendOverS register: 4)
						(ChainScripts bendOverS)
					)
					(else
						(HighPrint 260 23) ; "You don't see any dinars here."
					)
				)
			)
			((Said 'hide>')
				(cond
					(
						(or
							(Said '/armoire,armoire')
							(and (< 146 (gEgo x:) 180) (< (gEgo y:) 124))
						)
						(event claimed: 1)
						(if (== hiding 2)
							((ScriptID 261 1) next: (ScriptID 261 5)) ; getUpS, hideInWardrobeS
							(gEgo setScript: (ScriptID 261 1)) ; getUpS
						else
							(gEgo setScript: (ScriptID 261 5)) ; hideInWardrobeS
						)
					)
					((Said '[/corner]')
						(if (== hiding 4)
							((ScriptID 261 4) next: (ScriptID 261 2)) ; getOutS, hideInCornerS
							(gEgo setScript: (ScriptID 261 4)) ; getOutS
						else
							(gEgo setScript: (ScriptID 261 2)) ; hideInCornerS
						)
					)
					(else
						(HighPrint 260 24) ; "Hiding there would be very difficult."
					)
				)
				(event claimed: 1)
			)
			((Said '(get,get<out),done')
				(if (== hiding 4)
					(gEgo setScript: (ScriptID 261 4)) ; getOutS
				else
					(gEgo setScript: exitRoomS)
				)
			)
			((Said '(get,get<up),stand')
				(if (== hiding 2)
					(= hiding 0)
					(gEgo setScript: (ScriptID 261 1)) ; getUpS
				else
					(HighPrint 260 25) ; "You're standing tall already."
				)
			)
			((Said 'search/chest')
				(cond
					((IsFlag 59)
						(HighPrint 260 26) ; "You find nothing of value."
					)
					((or (not (rugRoll cel:)) (not (trapdoor cel:)))
						(HighPrint 260 27) ; "You see no chest here."
					)
					((not chestOpen)
						(HighPrint 260 19) ; "The chest is locked."
					)
					(else
						(bendOverS register: 5)
						(ChainScripts bendOverS)
					)
				)
			)
			((== hiding 4)
				(HighPrint 260 28) ; "You just can't do that inside the wardrobe."
				(event claimed: 1)
			)
		)
	)
)

(instance enterRoomS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					heading: 90
					loop: 0
					show:
					posn: 10 150
					setMotion: MoveTo 46 150 self
				)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(door stopUpd:)
				(cond
					((or (not (IsFlag 12)) (IsFlag 13) (< gTimeODay 6))
						(beingRobbedS start: 7)
						(gCurRoom setScript: beingRobbedS)
					)
					((!= gEgoGait 2) ; sneaking
						(gCurRoom setScript: isatUKamar)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance exitRoomS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 28 150 self)
			)
			(1
				(door setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo -10 150 self)
				(door stopUpd:)
			)
			(3
				(gCurRoom newRoom: 269)
			)
		)
	)
)

(instance rollRugS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo illegalBits: -16384)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 112 157 self)
			)
			(1
				(gEgo
					view: 47
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(= cycles 4)
			)
			(3
				(rugRoll setCycle: End self)
				(gEgo cel: 2)
			)
			(4
				(gEgo setCycle: Beg self)
				(if (not trapMsg)
					(HighPrint 260 29) ; "You find a trapdoor concealed below this carpet."
					(= trapMsg 1)
				)
			)
			(5
				(NormalEgo)
				(rugRoll stopUpd:)
				(cond
					((== kareemState 0)
						(gCurRoom setScript: kareemS)
					)
					((and (not (gCurRoom script:)) (not stealthy))
						(gCurRoom setScript: isatUKamar)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance unrollRugS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(NormalEgo)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 144 154 self)
			)
			(1
				(gEgo
					view: 47
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg)
				(rugRoll setCycle: Beg self)
			)
			(3
				(rugRoll stopUpd:)
				(if (and (not stealthy) (not (gCurRoom script:)))
					(gCurRoom setScript: isatUKamar)
				)
				(self dispose:)
			)
		)
	)
)

(instance bendOverS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 142 146 self)
			)
			(1
				(gEgo
					view: 47
					setLoop: 0
					cel: 0
					setPri: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(switch register
					(0
						(trapdoor setCel: 1)
						(RedrawCast)
						(CheckChest)
					)
					(1
						(trapdoor setCel: 0)
					)
					(2
						(if (PickLock 80 1 1)
							(HighPrint 260 30) ; "The chest's lock yields to your lock picking skill, the lid swings open, and you see some dinars within."
							(= chestOpen 1)
						)
					)
					(3
						(= chestOpen 0)
					)
					(4
						(= stoleMoney 1)
						(SolvePuzzle 705 3 2)
						(SkillUsed 14 -50) ; honor
						(gEgo get: 2 60) ; Dinar
						(HighPrint 260 31) ; "You find sixty dinars which you quickly put away."
					)
					(5
						(if (not stoleMoney)
							(HighPrint 260 31) ; "You find sixty dinars which you quickly put away."
							(= stoleMoney 1)
							(SolvePuzzle 705 3 2)
							(gEgo get: 2 60) ; Dinar
						)
						(SetFlag 59)
						(SolvePuzzle 704 5 2)
						(gEgo get: 56) ; SilverDagger
						(HighPrint 260 32) ; "Searching further, you find a false bottom in the chest.  Beneath it, you find a silver dagger which you take and stash away."
					)
				)
				(gEgo setPri: -1 setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(gEgo setMotion: MoveTo 136 146 self)
			)
			(4
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(5
				(trapdoor stopUpd:)
				(trapdoor cel:)
				(cond
					((and (not abdulState) (== register 0))
						(gCurRoom setScript: abdulS)
					)
					(
						(and
							(not jabbarState)
							(!= (gCurRoom script:) jabbarS)
							(OneOf register 4 5)
						)
						(gCurRoom setScript: jabbarS)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance kareemS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo illegalBits: -16384)
	)

	(method (changeState newState &tmp [str 120])
		(switch (= state newState)
			(0
				(HighPrint 260 33) ; "You hear the sound of someone singing something about a "Whirling dervisssh" and the sound of a key trying to find a lock."
				(SetFlag 13)
				(= cycles 4)
			)
			(1
				(door setCycle: End self)
			)
			(2
				(son
					setLoop: 0
					setCycle: Fwd
					posn: 2 148
					illegalBits: 0
					palette: 2
					init:
					setMotion: MoveTo 30 149 self
				)
			)
			(3
				(son
					setMotion: MoveTo 22 144
					setCycle: Rev
					cycleSpeed: 1
					moveSpeed: 1
				)
				(door setCycle: Beg self)
			)
			(4
				(door stopUpd:)
				(son
					setMotion: MoveTo 56 139 self
					setCycle: Fwd
					cycleSpeed: 0
					moveSpeed: 0
				)
			)
			(5
				(WhoPrint 0 260 34) ; "Is that you, Kareem?"
				(WhoPrint 1 260 35) ; "Yesh, Fathher."
				(= kareemState 2)
				(son setMotion: MoveTo 82 141 self cycleSpeed: 1 moveSpeed: 1)
			)
			(6
				(son setCycle: 0)
				(= cycles 8)
			)
			(7
				(son
					setCycle: Rev
					setMotion: MoveTo 66 136 self
					cycleSpeed: 2
					moveSpeed: 2
				)
			)
			(8
				(son setCycle: 0)
				(= cycles 4)
			)
			(9
				(son
					setCycle: Fwd
					setMotion: MoveTo 112 138 self
					cycleSpeed: 0
					moveSpeed: 0
				)
			)
			(10
				(son
					setCycle: Rev
					setMotion: MoveTo 105 138 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(11
				(son setCycle: 0)
				(= cycles 8)
			)
			(12
				(son
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 148 121 self
					cycleSpeed: 0
					moveSpeed: 0
				)
			)
			(13
				(son
					setCycle: Rev
					setMotion: MoveTo 138 122 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(14
				(son
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 160 121 self
					cycleSpeed: 0
					moveSpeed: 0
				)
			)
			(15
				(son
					setCycle: Rev
					setMotion: MoveTo 150 121 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(16
				(son
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 169 109 self
					cycleSpeed: 0
					moveSpeed: 0
				)
			)
			(17
				(son setLoop: 0 setCycle: Fwd setMotion: MoveTo 213 109 self)
			)
			(18
				(son
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 230 103 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(19
				(son
					setLoop: 0
					setMotion: MoveTo 250 96 self
					cycleSpeed: 2
					moveSpeed: 2
				)
			)
			(20
				(son setCycle: 0)
				(= cycles 3)
			)
			(21
				(son
					setCycle: Rev
					setMotion: MoveTo 240 97 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(22
				(son
					setCycle: Fwd
					setMotion: MoveTo 281 96 self
					setPri: 1
					cycleSpeed: 0
					moveSpeed: 0
				)
			)
			(23
				(if (not hiding)
					(HighPrint 260 36) ; "Lucky for you, Kareem was too inebriated to see you.  Better not press your luck next time. Find a good place to hide."
				else
					(HighPrint 260 37) ; "You look pretty silly hiding in the corner. You were just lucky that Kareem was very, very drunk."
				)
				(= checkStealth 16)
				(= kareemState 3)
				(son dispose:)
				(self dispose:)
			)
		)
	)
)

(instance abdulS of Script
	(properties)

	(method (changeState newState &tmp [str 120])
		(switch (= state newState)
			(0
				(= abdulState 1)
				(= cycles 8)
			)
			(1
				(HighPrint 260 38) ; "You hear a voice outside."
				(WhoPrint 2 260 39) ; "Now, is it this door?"
				(= seconds 3)
			)
			(2
				(WhoPrint 2 260 40) ; "I think I just passed the alleyway. But was I coming or going?"
				(= seconds 8)
			)
			(3
				(WhoPrint 2 260 41) ; "What was it father told me? If the key around my neck opens the lock... Ah! This must be my house."
				(= lastDifX (Abs (- 163 (gEgo x:))))
				(= lastDifY (Abs (- 103 (gEgo y:))))
				(= seconds 6)
			)
			(4
				(= cycles 10)
			)
			(5
				(if
					(or
						(== hiding 1)
						(== hiding 3)
						(MovingToWardrobe)
						(< (gEgo x:) 66)
					)
					(self changeState: 4)
				else
					(self cue:)
				)
			)
			(6
				(Print 260 42) ; "You hear a key turning in the lock."
				(= seconds 3)
			)
			(7
				(HandsOff)
				(= abdulState 2)
				(door setCycle: End self)
			)
			(8
				(son
					view: 358
					setCycle: Walk
					setLoop: -1
					setPri: -1
					posn: 5 149
					palette: 1
					init:
					ignoreActors:
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 52 151 self
				)
				(if (or (== hiding 1) (== hiding 3))
					(= hiding 0)
					(gEgo setMotion: 0 setScript: 0)
					(Face gEgo son)
				)
			)
			(9
				(WhoPrint 0 260 43) ; "Is that you, Abdul?"
				(WhoPrint 2 260 44) ; "I think so, Father."
				(door setCycle: Beg self)
			)
			(10
				(if (or catchHim (not hiding))
					(gCurRoom setScript: hiAbdulS)
				else
					(self cue:)
				)
			)
			(11
				(cond
					((and (rugRoll cel:) (trapdoor cel:))
						(WhoPrint 2 260 45) ; "Father, why is your secret hiding place open?"
						(WhoPrint 0 260 46) ; "WHAT??!!!!"
						(EgoDead
							1
							{Having discovered your presence, it takes but a short search to discover your hiding place.}
							#title
							{Clean up after yourself}
						)
					)
					((rugRoll cel:)
						(WhoPrint 2 260 47) ; "I wonder why father would have left the carpet rolled up? Oh well..."
						(son setMotion: MoveTo 189 154 self)
					)
					(else
						(son setMotion: MoveTo 189 120 self)
					)
				)
			)
			(12
				(son setMotion: MoveTo 224 97 self)
			)
			(13
				(son setPri: 1 setMotion: MoveTo 193 97 self)
			)
			(14
				(if (rugRoll cel:)
					(HighPrint 260 48) ; "You were lucky that Abdul wasn't smart enough to suspect a buglary. Next time, you'd best replace the rug."
				)
				(= checkStealth 16)
				(son dispose:)
				(= abdulState 3)
				(HandsOn)
				(switch hiding
					(2
						(HighPrint 260 49) ; "It's a good thing you are lucky, because you sure pick lousy places to hide."
						(= hiding 0)
						(self setScript: (ScriptID 261 1) self) ; getUpS
					)
					(4
						(HighPrint 260 50) ; "Your senses tell you that it might be safe to come out now."
						(self setScript: (ScriptID 261 4) self) ; getOutS
					)
					(else
						(self cue:)
					)
				)
			)
			(15
				(self dispose:)
			)
		)
	)
)

(instance hiAbdulS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo son)
				(son setMotion: MoveTo (- (gEgo x:) 24) (gEgo y:) self)
			)
			(1
				(Face son gEgo)
				(WhoPrint 2 260 51) ; "Have we met before?"
				(WhoPrint 2 260 52) ; "I'm Abdul, the youngest son of Abu bin Ma'amar."
				(if (rugRoll cel:)
					(WhoPrint 2 260 53) ; "Why are you fooling with father's secret hiding place which I'm not supposed ever to mention?"
				else
					(WhoPrint 2 260 54) ; "What are you doing in our house this time of night?"
				)
				(= cycles 6)
			)
			(2
				(WhoPrint 0 260 55) ; "Kamar! See what foolishness your brother is speaking of."
				(= cycles 16)
			)
			(3
				(kamar
					init:
					setPri: 1
					view: 294
					posn: 275 96
					setCycle: Walk
					setMotion: MoveTo 260 96 self
				)
			)
			(4
				(WhoPrint 4 260 56) ; "Grab him!"
				(WhoPrint 2 260 57) ; "Grab whom? Oh, him!"
				(Face son gEgo)
				(= gEgoGait 1) ; running
				(NormalEgo)
				(gEgo ignoreActors: setMotion: MoveTo 114 135 self)
			)
			(5
				(son stopUpd:)
				(beingRobbedS start: 2)
				(client setScript: beingRobbedS)
			)
		)
	)
)

(instance jabbarS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(HighPrint 260 58) ; "You hear two men talking outside the door."
				(WhoPrint 3 260 59) ; "Wasn't that fun today? It isn't often we get to torture a thief. If you ask me, criminals have too many rights these days."
				(= seconds 2)
			)
			(2
				(WhoPrint 5 260 60) ; "Boy, yeah! Can't wait 'till tomorrow when we get to cut off his OTHER hand!! Har har."
				(= seconds 3)
			)
			(3
				(WhoPrint 3 260 61) ; "Yeah, then he'll have no RIGHTS LEFT! Ho ho ho."
				(= seconds 3)
			)
			(4
				(WhoPrint 5 260 62) ; "See ya tomorrow, Jabbie, old buddy!"
				(WhoPrint 3 260 63) ; "Right! Ho ho ho!!"
				(Print 260 64) ; "(back-slap)"
				(if (!= hiding 4)
					(= lastDifX (Abs (- 163 (gEgo x:))))
					(= lastDifY (Abs (- 103 (gEgo y:))))
					(= cycles 10)
				else
					(self changeState: 9)
				)
			)
			(5
				(WhoPrint 3 260 65) ; "Oh, rat-dung! You made me drop my keys. Where'd they go?"
				(= jabbarWait 10)
				(= seconds 5)
			)
			(6
				(= cycles 8)
			)
			(7
				(if (and (not hiding) (-- jabbarWait))
					(self changeState: 6)
				else
					(self cue:)
				)
			)
			(8
				(if (or (== hiding 1) (== hiding 3) (MovingToWardrobe))
					(self changeState: 6)
				else
					(WhoPrint 3 260 66) ; "Here they are. See you tomorrow, Baddhi."
					(= seconds 3)
				)
			)
			(9
				(Print 260 42) ; "You hear a key turning in the lock."
				(= seconds 2)
			)
			(10
				(HandsOff)
				(door setCycle: End)
				(= cycles 8)
			)
			(11
				(jabbar
					setCycle: Walk
					posn: 5 149
					init:
					illegalBits: 0
					setMotion: MoveTo 67 145 self
				)
			)
			(12
				(door setCycle: Beg self)
			)
			(13
				(door stopUpd:)
				(cond
					((!= hiding 4)
						(WhoPrint 3 260 67) ; "Kamar! Come here! There is a thief in the house!"
						(EgoDead
							1
							{You'll have to think faster than that.}
							#title
							{Hiding is a Lost Art}
						)
					)
					((rugRoll cel:)
						(WhoPrint 3 260 68) ; "Yes, Father. But why is the carpet not over the secret trapdoor?"
						(WhoPrint 0 260 69) ; "WHAT??!!!"
						(EgoDead
							1
							{Having discovered your presence, it takes but a short search to discover your hiding place.}
							#title
							{Clean up after yourself}
						)
					)
					(else
						(WhoPrint 2 260 70) ; "I have returned from the late watch, Father."
					)
				)
				(= jabbarState 2)
				(= cycles 4)
			)
			(14
				(jabbar setMotion: MoveTo 189 120 self)
			)
			(15
				(jabbar setMotion: MoveTo 224 97 self)
			)
			(16
				(jabbar setPri: 1 setMotion: MoveTo 193 97 self)
			)
			(17
				(HighPrint 260 50) ; "Your senses tell you that it might be safe to come out now."
				(= checkStealth 16)
				(jabbar dispose:)
				(= jabbarState 3)
				(HandsOn)
				(self setScript: (ScriptID 261 4) self) ; getOutS
			)
			(18
				(self dispose:)
			)
		)
	)
)

(instance isatUKamar of Script
	(properties)

	(method (doit)
		(if (and (IsObject client) (MADENOISE))
			(client setScript: isatUKareem)
		else
			(super doit: &rest)
		)
	)

	(method (handleEvent event &tmp [str 10])
		(cond
			((super handleEvent: event))
			((Said 'yes,no')
				(WhoPrint 4 260 71) ; "Father, that was not me. There is someone else in the house!"
				(client setScript: beingRobbedS)
			)
			(
				(and
					(not ignoreNoise)
					(not stealthy)
					(not hiding)
					(Said 'say,talk,talk,yell')
				)
				(client setScript: isatUKareem)
			)
		)
	)

	(method (changeState newState &tmp [str 120])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0)
				(if (== (++ register) 6)
					(client setScript: beingRobbedS)
				)
				(if notHeardVoice
					(Print 260 72) ; "You hear the voice of an old man."
				)
				(WhoPrint 0 260 73) ; "Is that you, Kamar?"
				(DontTalk 0)
				(= cycles 14)
			)
			(1
				(HandsOn)
				(if notHeardVoice
					(= notHeardVoice 0)
					(Print 260 74) ; "You hear another voice."
				)
				(WhoPrint 4 260 75) ; "No, Father."
				(= seconds 5)
			)
			(2
				(HuhPrint)
				(self dispose:)
			)
		)
	)
)

(instance isatUKareem of Script
	(properties)

	(method (doit)
		(if (and (IsObject client) (MADENOISE))
			(client setScript: isatUAbdul)
		else
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(HandsOn)
	)

	(method (handleEvent event &tmp [str 10])
		(cond
			((super handleEvent: event))
			((and kareemState (Said 'yes,no'))
				(WhoPrint 1 260 76) ; "But Faddher, that wasn' me who jusht said that."
				(client setScript: beingRobbedS)
			)
			((Said 'yes')
				(= ignoreNoise 56)
				(self dispose:)
			)
			((Said 'no')
				(client setScript: isatUAbdul)
			)
			(
				(and
					(not ignoreNoise)
					(not stealthy)
					(not hiding)
					(Said 'say,talk,talk,yell')
				)
				(client setScript: isatUAbdul)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0)
				(WhoPrint 0 260 34) ; "Is that you, Kareem?"
				(= cycles 16)
				(DontTalk 0)
			)
			(1
				(HandsOn)
				(if (== kareemState 3)
					(WhoPrint 1 260 75) ; "No, Father."
				)
				(= seconds 5)
			)
			(2
				(HuhPrint)
				(self dispose:)
			)
		)
	)
)

(instance isatUAbdul of Script
	(properties)

	(method (doit)
		(if (and (IsObject client) (MADENOISE))
			(client setScript: isatUJabbar)
		else
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(HandsOn)
	)

	(method (handleEvent event &tmp [str 10])
		(cond
			((super handleEvent: event))
			((and abdulState (Said 'yes,no'))
				(WhoPrint 2 260 77) ; "Oh, I thought I was in here. I guess I must be in the other room."
				(client setScript: beingRobbedS)
			)
			((Said 'yes')
				(= ignoreNoise 56)
				(self dispose:)
			)
			((Said 'no')
				(client setScript: isatUJabbar)
			)
			(
				(and
					(not ignoreNoise)
					(not stealthy)
					(not hiding)
					(Said 'say,talk,talk,yell')
				)
				(client setScript: isatUJabbar)
			)
		)
	)

	(method (changeState newState &tmp [str 120])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0)
				(WhoPrint 0 260 43) ; "Is that you, Abdul?"
				(DontTalk 0)
				(= cycles 12)
			)
			(1
				(HandsOn)
				(if (== abdulState 3)
					(WhoPrint 1 260 75) ; "No, Father."
				)
				(if abdulState
					(WhoPrint 2 260 78) ; "No, Fathher."
				)
				(= seconds 5)
			)
			(2
				(HuhPrint)
				(self dispose:)
			)
		)
	)
)

(instance isatUJabbar of Script
	(properties)

	(method (doit)
		(if (and (IsObject client) (MADENOISE))
			(client setScript: beingRobbedS)
		else
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(HandsOn)
	)

	(method (handleEvent event &tmp [str 10])
		(cond
			((super handleEvent: event))
			((and jabbarState (Said 'yes,no'))
				(WhoPrint 3 260 79) ; "Kamar! There is someone in the house!"
				(client setScript: beingRobbedS)
			)
			((Said 'yes')
				(= ignoreNoise 56)
				(self dispose:)
			)
			((Said 'no')
				(client setScript: isatUJabbar)
			)
			(
				(and
					(not ignoreNoise)
					(not stealthy)
					(not hiding)
					(Said 'say,talk,talk,yell')
				)
				(client setScript: beingRobbedS)
			)
		)
	)

	(method (changeState newState &tmp [str 120])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0)
				(WhoPrint 0 260 80) ; "Is that you, Jabbar?"
				(DontTalk 0)
				(= cycles 20)
			)
			(1
				(HandsOn)
				(if (== jabbarState 3)
					(WhoPrint 3 260 75) ; "No, Father."
				)
				(= seconds 5)
			)
			(2
				(HuhPrint)
				(self dispose:)
			)
		)
	)
)

(instance beingRobbedS of HandsOffScript
	(properties)

	(method (changeState newState &tmp [str 120])
		(switch (= state newState)
			(0
				(WhoPrint 0 260 81) ; "My Sons! Kamar! Kareem! Abdul! Jabbar! The house is being robbed!"
				(self changeState: (if jabbarState 7 else 1))
			)
			(1
				(gEgo setMotion: MoveTo 110 135 self)
				(kamar
					init:
					setPri: 1
					setLoop: -1
					view: 294
					posn: 275 96
					setCycle: Walk
					setMotion: MoveTo 222 113
				)
			)
			(2
				(gEgo setMotion: MoveTo 102 137)
				(door setCycle: End self)
			)
			(3
				(jabbar
					init:
					setLoop: -1
					view: 294
					posn: 2 148
					setPri: 3
					setCycle: Walk
					setMotion: MoveTo 55 142 self
				)
			)
			(4
				(door setCycle: Beg)
				(gEgo setMotion: MoveTo 151 124)
				(kamar setPri: -1 setMotion: MoveTo 180 116 self)
			)
			(5
				(door stopUpd:)
				(jabbar setPri: -1 setMotion: MoveTo 71 140)
				(gEgo setMotion: MoveTo 104 135 self)
			)
			(6
				(if catchHim
					(EgoDead
						1
						{An experienced thief knows when not to press his luck.}
						#title
						{Can't Take a Hint?}
					)
				else
					(EgoDead
						1
						{While running for home.  Looks like a squeeze play!  You'll never get to first base if you don't remember the basics.   Thieves' Handbook rule number one: When in doubt, don't.}
						#title
						{Caught stealing...}
					)
				)
			)
			(7
				(kamar
					init:
					setLoop: -1
					setPri: 1
					posn: 197 97
					setCycle: Walk
					setMotion: MoveTo 223 96 self
				)
			)
			(8
				(Face kamar gEgo)
				(gEgo setMotion: MoveTo 136 131 self)
			)
			(9
				(Face gEgo kamar)
				(if (!= gEgoGait 2) ; sneaking
					(= gEgoGait 2) ; sneaking
					(NormalEgo)
					(gEgo illegalBits: 0 ignoreActors:)
				)
				(kamar setPri: -1 setMotion: MoveTo 222 106 self)
				(gEgo setLoop: 6 setCycle: Rev setMotion: MoveTo 44 150)
			)
			(10
				(kamar setMotion: MoveTo 186 111)
				(jabbar
					init:
					setLoop: -1
					setPri: 1
					posn: 277 97
					setCycle: Walk
					setMotion: MoveTo 240 105 self
				)
			)
			(11
				(kamar setMotion: MoveTo 174 113)
				(jabbar setPri: -1 setMotion: MoveTo 195 130 self)
			)
			(12
				(EgoDead
					0
					(Format
						@str
						{What a blitz!  It looks like you lost yardage on that play.  Brothers: 6, %s: 0. }
						@gUserName
					)
					#title
					{Quarterback sack...}
				)
			)
		)
	)
)

(instance son of TargActor
	(properties
		noun '/man,son'
		description {the man}
		lookStr {The man looks to be dazed for some reason.}
		yStep 3
		view 358
		illegalBits 0
		xStep 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(HighPrint 260 82) ; "That's a bad idea, unless you LIKE getting caught."
		else
			(super doVerb: theVerb)
		)
	)

	(method (hurtMe)
		(EgoDead 1 260 83 #title {You kill me!}) ; "The trial was shorter than you expected, and now so are you.  A full head shorter to be exact."
		(return 1)
	)

	(method (fetchMe)
		(HighPrint 260 84) ; "You can't fetch someone that big."
	)
)

(instance kamar of TargActor
	(properties
		noun '/man,son,guard'
		description {Kamar}
		lookStr {He is wearing the uniform of a palace guard.  This is bad.  Very bad.}
		yStep 3
		view 294
		illegalBits 0
		xStep 4
	)

	(method (hurtMe)
		(HighPrint 260 85) ; "He's hurt a little, but you're also making him more angry."
		(return 1)
	)

	(method (fetchMe)
		(HighPrint 260 84) ; "You can't fetch someone that big."
	)
)

(instance jabbar of TargActor
	(properties
		noun '/man,son,guard'
		description {Jabbar}
		lookStr {He is wearing the uniform of a palace guard.  This is bad.  Very bad.}
		yStep 3
		view 294
		illegalBits 0
		xStep 4
	)

	(method (hurtMe)
		(HighPrint 260 85) ; "He's hurt a little, but you're also making him more angry."
		(return 1)
	)

	(method (fetchMe)
		(HighPrint 260 84) ; "You can't fetch someone that big."
	)
)

(instance pots of TargActor
	(properties
		x 81
		y 109
		noun '/pan,vase'
		description {the pots on the shelf}
		lookStr {The pots on the shelf are pretty, but pretty worthless.}
		view 260
		loop 4
		signal 6144
		illegalBits 0
	)

	(method (fetchMe)
		(EgoDead
			1
			{As the pieces of pottery hurtle towards you, you realize that you can't possibly catch them all.  Several fall to the floor, crashing loudly and alerting the old man.  The pottery was worthless, so your sentence is less severe than it might have been.  (They cut only one of your hands off.)}
			#title
			{Give Me a Hand}
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 260 86) ; "A good thief knows worthless pottery when he sees it, and this is it. It's not worth your trouble."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rugRoll of Prop
	(properties
		x 165
		y 144
		noun '[<at]/carpet[<big,red]'
		description {the large rug}
		lookStr {The large rug is too large to steal.  It simply covers what's beneath it.}
		view 260
		loop 1
		priority 8
		signal 16400
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 5)
			(if (rugRoll cel:)
				(HighPrint 260 11) ; "You have already rolled up the carpet."
			else
				(ChainScripts rollRugS)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of TargActor
	(properties
		y 151
		noun '/door[<alley,wooden]'
		description {the door to the alley}
		lookStr {The heavy wooden door leads to the alley.}
		view 261
		loop 4
		cel 2
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (openMe)
		(HighPrint 260 87) ; "The wooden door's latch seems to be stuck. It doesn't respond."
	)

	(method (setCycle type)
		(switch type
			(Beg
				(self setPri: 1)
			)
			(End
				(self setPri: 12)
			)
		)
		(super setCycle: type &rest)
	)
)

(instance drapes of TargActor
	(properties
		x 245
		y 94
		noun '/curtain'
		description {the drapes}
		lookStr {Drapes cover a doorway which undoubtedly leads to the old man's bed chamber.}
		view 260
		loop 7
	)

	(method (cue)
		(EgoDead
			1
			{As it strikes the drapes, the sound frightens the old man.  He calls for his sons, who are angry.  VERY angry.  And violent.  VERY, VERY violent.}
			#title
			{Painful, VERY Painful!}
		)
	)

	(method (hurtMe)
		(self cue:)
	)

	(method (openMe)
		(self cue:)
	)

	(method (fetchMe)
		(self cue:)
	)
)

(instance trapdoor of TargActor
	(properties
		x 149
		y 141
		noun '/(door<trap),trap,trap'
		description {the trapdoor}
		lookStr {There appears to be a trapdoor built into the boards of the floor.}
		view 260
		loop 6
		signal 16400
	)

	(method (isNotHidden)
		(rugRoll cel:)
	)

	(method (openMe)
		(cond
			((not (rugRoll cel:))
				(HighPrint 260 88) ; "You can't open the rug."
			)
			((not (trapdoor cel:))
				(self setCel: 1)
				(HighPrint 260 89) ; "The trapdoor swings open."
				(RedrawCast)
				(CheckChest)
				(if (not abdulState)
					(gCurRoom setScript: abdulS)
				)
			)
			(chestOpen
				(HighPrint 260 18) ; "The chest is already open."
			)
			(else
				(Print 260 90) ; "The chest's lock springs open, the lid swings wide, and you see some dinars within."
				(= chestOpen 1)
			)
		)
	)

	(method (fetchMe)
		(cond
			((not (rugRoll cel:))
				(HighPrint 260 91) ; "You can't fetch the rug. It's much too large."
			)
			((not (trapdoor cel:))
				(HighPrint 260 92) ; "You can't fetch the trapdoor."
			)
			(stoleMoney
				(HighPrint 260 93) ; "You've already taken the dinars from the chest."
			)
			(chestOpen
				(= stoleMoney 1)
				(SolvePuzzle 705 3 2)
				(gEgo get: 2 60) ; Dinar
				(HighPrint 260 94) ; "Your spell latches on to the sixty dinars."
				(if (not jabbarState)
					(gCurRoom setScript: jabbarS)
				)
			)
			(else
				(HighPrint 260 95) ; "You can't fetch the chest. It's much too heavy."
			)
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(if (not (rugRoll cel:))
			(HighPrint 260 96) ; "You don't see any trapdoor here."
		else
			(switch theVerb
				(2
					(if cel
						(AlreadyDone)
					else
						(bendOverS register: 0)
						(ChainScripts bendOverS)
					)
				)
				(3
					(if (not (trapdoor cel:))
						(HighPrint 260 97) ; "The trapdoor is closed."
					else
						(bendOverS register: 1)
						(ChainScripts bendOverS)
					)
				)
				(1
					(if cel
						(HighPrint 260 98) ; "You see a large chest."
					else
						(HighPrint lookStr)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance myWindow of TopWindow
	(properties)
)

(instance myVerbs of VerbMessager
	(properties
		ssLook 'look,look>'
		ssOpen 'open,open>'
		ssClose 'close,close>'
		ssSmell 'smell>'
		ssMove 'move>'
		ssEat 'eat,eat>'
		ssGet 'get,get,grab,(lockpick<up)>'
		ssClimb 'climb,climb>'
		ssTalk 'talk,talk,talk>'
	)
)

