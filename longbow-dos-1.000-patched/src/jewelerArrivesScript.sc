;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 403)
(include sci.sh)
(use Main)
(use n013)
(use rm400)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Approach)
(use Motion)
(use User)
(use Actor)

(public
	jewelerArrivesScript 0
	matilda 1
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
	[local8 9] = [404 0 2 4 25 29 22 20 18]
	[local17 11] = [1403 0 1 3 2 3 3 1 3 2 0]
	[local28 10] = [1403 8 1 1 3 3 1 2 3 0]
	[local38 7] = [1403 16 2 1 1 3 0]
	[local45 5] = [1403 20 2 1 0]
	[local50 4] = [1403 22 2 0]
	[local54 7] = [1403 23 3 1 3 3 0]
	[local61 4] = [1403 27 2 0]
	[local65 4] = [1403 28 1 0]
	[local69 5] = [1403 29 1 2 0]
	[local74 4] = [1403 32 2 0]
	[local78 5] = [1403 33 1 2 0]
	[local83 4] = [1403 35 2 0]
	[local87 6] = [1403 36 1 3 3 0]
	[local93 5] = [1403 39 1 3 0]
	[local98 6] = [1403 41 1 3 3 0]
	[local104 4] = [1403 44 3 0]
	[local108 4] = [1403 45 1 0]
	[local112 6] = [1403 46 1 2 2 0]
	[local118 6] = [1403 50 2 2 1 0]
	[local124 7] = [1403 53 1 3 3 2 0]
	[local131 5] = [1403 57 1 3 0]
	[local136 6] = [1403 59 3 2 1 0]
	[local142 7] = [1403 63 1 3 3 2 0]
	[local149 5] = [1403 67 1 2 0]
	[local154 5] = [1403 69 1 2 0]
	[local159 5] = [1403 71 1 3 0]
	[local164 6] = [1403 73 1 3 3 0]
	[local170 8] = [1403 76 2 2 1 2 2 0]
	[local178 4] = [1403 81 2 0]
	[local182 5] = [1403 82 3 3 0]
	[local187 4] = [1403 84 3 0]
	[local191 10] = [1403 85 2 2 1 2 1 2 2 0]
	[local201 4] = [1403 92 2 0]
	[local205 5] = [1403 93 3 3 0]
	[local210 4] = [1403 95 3 0]
	[local214 13] = [1403 96 1 3 3 2 3 2 1 2 1 3 0]
	[local227 5] = [1403 106 2 1 0]
	[local232 9] = [1403 108 2 1 1 2 1 2 0]
	[local241 34] = [1403 114 2 1 2 1 1 3 1 1 3 1 1 1 3 1 2 2 1 2 1 2 1 1 2 1 2 1 3 3 2 2 2 0]
	[local275 4] = [1403 145 3 0]
	[local279 5] = [1403 146 1 3 0]
	[local284 6] = [1403 148 2 1 3 0]
	[local290 4] = [1403 151 1 0]
	[local294 4] = [1403 152 3 0]
)

(procedure (localproc_0 param1)
	(Converse 3 param1 999 3 12 1 @local8 0 &rest)
)

(instance jewelerArrivesScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((= local0 (ScriptID 400 2)) actions: SheriffJewelerActions) ; sheriff
				((= local1 (ScriptID 400 3)) actions: TableActions) ; table
				(= local2 (ScriptID 400 4)) ; guards
				(= local3 (ScriptID 400 5)) ; giles
				(= local4 (ScriptID 400 6)) ; roger
				(SetFlag 145)
				(matilda
					approachX: (local1 approachX:)
					approachY: (local1 approachY:)
					approachVerbs: 5 ; Talk
				)
				(jewelProp init: hide:)
				(gEgo
					setMotion:
						MoveTo
						(local1 approachX:)
						(local1 approachY:)
						self
				)
			)
			(1
				(= cycles 1)
			)
			(2
				(if (and (== gDisguiseNum 2) (IsFlag 10)) ; jewler (no rouge)
					(self setScript: blondScript)
				else
					(localproc_0 @local28 self) ; "Sire, I can tell by your noble bearing that you must be the illustrious Sheriff of Nottingham, famed in song and legend."
				)
			)
			(3
				(HandsOn)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(super doit: &rest)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(cond
			(
				(not
					(= temp2
						(if (User controls:)
							(gEgo mover:)
						)
					)
				)
				(return)
			)
			((= temp5 (temp2 isMemberOf: PolyPath))
				(= temp3 (temp2 finalX:))
				(= temp4 (temp2 finalY:))
			)
			(else
				(= temp3 (temp2 x:))
				(= temp4 (temp2 y:))
			)
		)
		(if (and (== temp0 temp3) (== temp1 temp4))
			(return)
		)
		(if (and 1 (< temp3 (gEgo x:)))
			(gEgo setMotion: 0)
			(if local7
				(client setScript: getTableJewels)
			else
				(client setScript: leaveBeforeJewels)
			)
		)
	)
)

(instance showJewel of TScript
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(NormalEgo)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(= temp3 ((= temp2 local1) approachX:))
				(= temp4 (temp2 approachY:))
				(if (or (!= temp0 temp3) (!= temp1 temp4))
					(gEgo setMotion: MoveTo temp3 temp4 self)
				else
					(gEgo setMotion: 0)
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 32
					loop: 0
					cel: 0
					heading: 90
					setCycle: CT 2 1 self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo 0)
				(self dispose:)
			)
		)
	)
)

(instance blondScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 @local17 self) ; "Most illustrious Lord and Lady--"
			)
			(1
				(local2 setMotion: Approach gEgo 1 self)
			)
			(2
				(local2 setMotion: GuardFollow gEgo 30)
				(gEgo setMotion: MoveTo 20 (gEgo y:) self)
			)
			(3
				(= gDeathNum 9)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance jewelProp of Prop
	(properties
		x 162
		y 150
		z 22
		view 400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== 0 (& signal $0080))
					(gCurRoom setScript: getTableJewels)
				)
			)
			(else
				((gInventory at: 7) doVerb: theVerb invItem &rest) ; jewels
			)
		)
	)
)

(instance getTableJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: gatherJewels self)
			)
			(1
				(localproc_0 @local54 self) ; "What are you doing?!"
			)
			(2
				(self setScript: spreadJewels self)
			)
			(3
				(localproc_0 @local61 self) ; "Gragh....very well."
			)
			(4
				(self setScript: sheriffConvinced self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance gatherJewels of TScript
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gEgo get: 7) ; jewels
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(= temp3 ((= temp2 local1) approachX:))
				(= temp4 (temp2 approachY:))
				(if (or (!= temp0 temp3) (!= temp1 temp4))
					(gEgo setMotion: MoveTo temp3 temp4 self)
				else
					(gEgo setMotion: 0)
					(self cue:)
				)
			)
			(1
				(gEgo view: 32 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(jewelProp loop: 1 setCycle: Beg self)
			)
			(3
				(jewelProp hide:)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo 0)
				(self dispose:)
			)
		)
	)
)

(instance spreadJewels of TScript
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gEgo put: 7) ; jewels
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(= temp3 ((= temp2 local1) approachX:))
				(= temp4 (temp2 approachY:))
				(if (or (!= temp0 temp3) (!= temp1 temp4))
					(gEgo setMotion: MoveTo temp3 temp4 self)
				else
					(gEgo setMotion: 0)
					(self cue:)
				)
			)
			(1
				(gEgo view: 32 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(jewelProp loop: 1 show: setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo 0)
				(self dispose:)
			)
		)
	)
)

(instance leaveBeforeJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(localproc_0 @local45 self) ; "I didn't give you permission to leave. How dare you turn your back on me!"
			)
			(1
				(local0 loop: 2 setCycle: End self)
			)
			(2
				(localproc_0 @local50 self) ; "Toss this rude popinjay out and see that he doesn't return!"
			)
			(3
				(local2 setMotion: Approach gEgo 15 self)
			)
			(4
				(local2 setMotion: GuardFollow gEgo 15)
				(gEgo setMotion: MoveTo -5 (gEgo y:))
			)
		)
	)
)

(instance sheriffConvinced of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local38 self) ; "I agree to your conditions. Let us go at once!"
			)
			(1
				(SetScore 300)
				(SetFlag 181)
				(gCurRoom newRoom: 240) ; robbedOne
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance jewelerTalkToSheriffAfterJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(localproc_0 (if (== register 1) @local78 else @local83) self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance jewelerTalkToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(localproc_0 (if (== register 1) @local69 else @local74) self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance matilda of Prop
	(properties
		x 151
		y 131
		z 7
		lookStr {My tongue nearly strangles itself to flatter this well-larded nag!}
		view 403
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say [local65 0] [local65 1])
			)
			(5 ; Talk
				(self setScript: jewelerTalkToMatilda)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say [local108 0] [local108 1])
					)
					(2 ; halfHeart
						(self
							setScript:
								(if local7 EmToMatildaJewels else EmToMatilda)
						)
					)
					(14 ; amethyst
						(self
							setScript:
								(if local7 AmToMatildaJewels else AmToMatilda)
						)
					)
					(10 ; fireRing
						(self
							setScript:
								(if local7
									FireToMatildaJewels
								else
									FireToMatilda
								)
						)
					)
					(18 ; waterRing
						(self
							setScript:
								(if local7
									WaterToMatildaJewels
								else
									WaterToMatilda
								)
						)
					)
					(7 ; jewels
						(localproc_0 (if local7 @local279 else @local275))
					)
					(8 ; rouge
						(self setScript: RougeToMatilda)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance EmToMatilda of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 @local131 self) ; "If I might show you but one jewel that I carry--"
			)
			(1
				(proc400_1 gEgo 10 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance EmToMatildaJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 @local136 self) ; "Well! That's a pretty emerald, but oddly cut. Not to my taste."
			)
			(1
				(proc400_1 gEgo 10 self)
			)
			(2
				(localproc_0 @local142 self) ; "But if you demand more proof than this, then I shall give up and leave at once."
			)
			(3
				(self setScript: sheriffConvinced self register)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance AmToMatilda of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local159 self) ; "If your Ladyship would care to examine this amethyst---"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance AmToMatildaJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local164 self) ; "I'll gladly give you this amethyst if you'll help the Sheriff change his mind."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance FireToMatilda of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local182 self) ; "It is a glorious ruby, but a man's ring."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance FireToMatildaJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local187 self) ; "What a shame that glorious ruby is set in a man's ring."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance WaterToMatilda of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local205 self) ; "That sapphire is perfect, but set in a man's ring."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance WaterToMatildaJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local210 self) ; "How sad that perfect sapphire is set in a man's ring."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance RougeToMatilda of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 @local290 self) ; "Allow me to gift you with some rouge, for I've heard you have a fine collection of jewels."
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(local1 approachX:)
						(local1 approachY:)
						self
				)
			)
			(2
				(proc400_1 gEgo 10 self)
			)
			(3
				(localproc_0 @local294 self) ; "Good, I was running low and have many fine pieces of jewelry in need of a polish."
			)
			(4
				(gEgo put: 8 gCurRoomNum) ; rouge
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance jewelerTalkToMatilda of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(localproc_0
					(cond
						((not local7)
							(if (== register 1) @local87 else @local93)
						)
						((== register 1) @local98)
						(else @local104)
					)
					self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance EmToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 @local112 self) ; "I have one jewel in particular that--"
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance EmToSheriffJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= notKilled 1)
				(localproc_0 @local118 self) ; "Now THAT is truly a magnificent jewel!"
			)
			(1
				(localproc_0 @local124 self) ; "But if you demand more proof than this, then I shall give up and leave at once."
			)
			(2
				(self setScript: sheriffConvinced self register)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance AmToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local149 self) ; "I have this amethyst crystal in my wares."
			)
			(2
				(proc400_1 gEgo 10 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance AmToSheriffJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local154 self) ; "Will this change your mind?"
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance FireToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local170 self) ; "This is all you have to show?"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance FireToSheriffJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local178 self) ; "It's a nice enough ring, but it's not proof enough."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance WaterToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local191 self) ; "This is all you have to show?"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance WaterToSheriffJewels of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local201 self) ; "You'll not wring 5,000 marks from me with only this for proof."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance JewelsToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 (= notKilled 1))
				(self setScript: spreadJewels self)
			)
			(1
				(localproc_0 @local214 self) ; "Feast your eyes upon this exquisite workmanship and the finest jewels of all creation!"
			)
			(2
				(local0 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(localproc_0 @local227 self) ; "Matilda! Still your tongue, woman."
			)
			(4
				(local0 setCycle: Beg self)
			)
			(5
				(local0 loop: 0 cel: 0 setCycle: 0)
				(localproc_0 @local232 self) ; "Then you'll take the 50 marks?!"
			)
			(6
				(local2 setMotion: MoveTo -35 (local2 y:) self)
			)
			(7
				(localproc_0 @local241 self) ; "Come, my friend, tell me all."
			)
			(8
				(local2 setMotion: Approach gEgo 30 self)
			)
			(9
				(local2 setMotion: GuardFollow gEgo 30)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance RougeToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: showJewel self)
			)
			(1
				(localproc_0 @local284 self) ; "Why the devil are you giving me this?"
			)
			(2
				(gEgo put: 8 gCurRoomNum) ; rouge
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance TableActions of SpecialDoVerb
	(properties)

	(method (doVerb)
		(return
			(or
				(and local7 (jewelProp doVerb: &rest))
				(SheriffJewelerActions doVerb: &rest)
			)
		)
	)
)

(instance SheriffJewelerActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem &tmp temp0 temp1)
		(= temp0 local0)
		(= temp1 1)
		(switch theVerb
			(5 ; Talk
				(temp0
					setScript:
						(if local7
							jewelerTalkToSheriffAfterJewels
						else
							jewelerTalkToSheriff
						)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say [local108 0] [local108 1])
					)
					(2 ; halfHeart
						(cond
							((== local6 0)
								(= local6 1)
								(gEgo setScript: EmToSheriff)
							)
							(local7
								(gEgo setScript: EmToSheriffJewels)
							)
							(else
								(Say 1403 49 1) ; "He wouldn't look at it the first time I offered. Clearly, he needs more convincing of my goods before he'll look at the emerald."
							)
						)
					)
					(14 ; amethyst
						(temp0
							setScript:
								(if local7 AmToSheriffJewels else AmToSheriff)
						)
					)
					(10 ; fireRing
						(temp0
							setScript:
								(if local7
									FireToSheriffJewels
								else
									FireToSheriff
								)
						)
					)
					(18 ; waterRing
						(temp0
							setScript:
								(if local7
									WaterToSheriffJewels
								else
									WaterToSheriff
								)
						)
					)
					(7 ; jewels
						(temp0 setScript: JewelsToSheriff)
					)
					(8 ; rouge
						(temp0 setScript: RougeToSheriff)
					)
					(else
						(= temp1 0)
					)
				)
			)
			(else
				(= temp1 0)
			)
		)
		(return temp1)
	)
)

