;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use Smopper)
(use n819)
(use Motion)
(use Inventory)
(use System)

(public
	delExit 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (!= param1 local0))
	(= local0 param1)
	(if (and temp0 (== argc 2))
		(param2 start: (param2 state:))
		(gDelph talkScript: param2)
	else
		(gDelph talkScript: 0)
		(SetFlag 107)
	)
	(return temp0)
)

(instance delExit of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 201)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalDelph)
				(gDelph
					loop: 0
					cel: 6
					posn: 182 91
					xStep: 7
					z: 0
					heading: 90
					setPri: 0
					init:
					lookStr: 15
				)
				(= cycles 3)
			)
			(1
				(gDelph setMotion: MoveTo 266 91 self)
			)
			(2
				(gDelph setCycle: Smopper 836 0 0 20 setHeading: 180 self)
			)
			(3
				(if (not (SetFlag 76))
					((ScriptID 2 0) init: 2 1 self) ; Delphineus, "Whew! Things have gotten even worse since the last time I was here! I'm trying to help out in the Fish Apartments now, but I'm afraid I'm not much good at this sort of thing."
				else
					(= cycles 1)
				)
			)
			(4
				(cond
					((IsFlag 116)
						(self setScript: HDirtyShell self)
					)
					((not (IsFlag 29))
						(self setScript: HBeforeOracle self)
					)
					((not (IsFlag 4))
						(self setScript: HFinishOracle self)
					)
					((and (not (IsFlag 27)) (not (IsFlag 11)))
						(self setScript: HBeforeMayor self)
					)
					((and (IsFlag 2) (not (IsFlag 11)))
						(self setScript: HTalkToSuperfl self)
					)
					(
						(and
							(IsFlag 3)
							(not (IsFlag 2))
							(not (IsFlag 11))
						)
						(self setScript: HBeforeSuperfl self)
					)
					((and (IsFlag 11) (not (IsFlag 27)))
						(self setScript: HBeforeDemeter self)
					)
					((and (IsFlag 27) (not (IsFlag 3)))
						(self setScript: HNoCouncilChambers self)
					)
					(
						(and
							(IsFlag 11)
							(IsFlag 27)
							(not (== ((Inv at: 22) owner:) 160)) ; hermetShell
						)
						(self setScript: HNoShell self)
					)
				)
			)
			(5
				(if (not (gCurRoom script:))
					(HandsOn)
				)
				(= seconds 10)
			)
			(6
				(if (not (gCurRoom script:))
					(HandsOff)
				)
				((ScriptID 2 0) init: 25 1 self) ; Delphineus, "You can hang out here if you want, Adam. I've gotta go to the surface to breathe. See ya back here later."
			)
			(7
				(gDelph talkScript: 0 setMotion: MoveTo 376 9 self)
			)
			(8
				(if (not (gCurRoom script:))
					(HandsOn)
				)
				(gDelph dispose:)
				(self dispose:)
			)
		)
	)
)

(instance HBeforeOracle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 1 self) ; Delphineus, "Have you found the Oracle yet?"
			)
			(1
				((ScriptID 2 1) init: 5 1 self) ; Adam, "No. Not yet."
			)
			(2
				(if (localproc_0 1 self)
					((ScriptID 2 0) init: 4 1 self) ; Delphineus, "Oh. Don't worry, you'll find her."
				else
					((ScriptID 2 0) init: 5 1 self) ; Delphineus, "You might try looking around the Temple for the Oracle."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance HFinishOracle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 1 self) ; Delphineus, "Have you found the Oracle yet?"
			)
			(1
				((ScriptID 2 1) init: 17 1 self) ; Adam, "I found her all right, but I'm not sure what to do next!"
			)
			(2
				(if (localproc_0 2 self)
					((ScriptID 2 0) init: 26 1 self) ; Delphineus, "Just talk to her, Adam. She'll let you know what to do."
				else
					((ScriptID 2 0) init: 27 1 self) ; Delphineus, "Talk to the Oracle and then answer her riddles and maybe she'll let you help Eluria."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance HBeforeMayor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "Have you found the Mayor or the Guardian of the Greens yet?"
			)
			(1
				((ScriptID 2 1) init: 5 1 self) ; Adam, "No. Not yet."
			)
			(2
				(if (localproc_0 3 self)
					((ScriptID 2 0) init: 10 1 self) ; Delphineus, "Don't worry. You'll find 'em. Just look around the city."
				else
					((ScriptID 2 0) init: 11 1 self) ; Delphineus, "Well, you might try looking around in the Council Chambers."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance HBeforeSuperfl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "Have you found the Mayor or the Guardian of the Greens yet?"
			)
			(1
				((ScriptID 2 1) init: 8 1 self) ; Adam, "Well, I haven't found the Mayor, but I did hear a strange voice in the Council Chambers."
			)
			(2
				((ScriptID 2 0) init: 13 1 self) ; Delphineus, "Hmm. I don't know who that might be. What did the voice say?"
			)
			(3
				((ScriptID 2 1) init: 9 1 self) ; Adam, "It said something about the columns."
			)
			(4
				(if (localproc_0 4 self)
					((ScriptID 2 0) init: 14 1 self) ; Delphineus, "Oh, yeah! The Council Chamber columns! If you can straighten out those columns, maybe the voice would tell you more."
				else
					((ScriptID 2 0) init: 28 1 self) ; Delphineus, "The legend says the columns on the left side of the Council Chambers should be lined up to match the columns on the right side of the Council Chambers."
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance HTalkToSuperfl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "Have you found the Mayor or the Guardian of the Greens yet?"
			)
			(1
				((ScriptID 2 1) init: 18 1 self) ; Adam, "I saw a crying crab, but I don't know what to do about it."
			)
			(2
				(if (localproc_0 6 self)
					((ScriptID 2 0) init: 29 1 self) ; Delphineus, "Maybe he needs a friend."
				else
					((ScriptID 2 0) init: 30 1 self) ; Delphineus, "Try talking to the crying crab."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance HBeforeDemeter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "Have you found the Mayor or the Guardian of the Greens yet?"
			)
			(1
				((ScriptID 2 1) init: 10 1 self) ; Adam, "I found the Mayor, Superfluous, but I haven't found the Guardian of the Greens yet."
			)
			(2
				(if (localproc_0 5 self)
					((ScriptID 2 0) init: 16 1 self) ; Delphineus, "Well, she should be somewhere around the city."
				else
					((ScriptID 2 0) init: 17 1 self) ; Delphineus, "You might try looking around the Royal Gardens for the Guardian of the Greens."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance HNoCouncilChambers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "Have you found the Mayor or the Guardian of the Greens yet?"
			)
			(1
				((ScriptID 2 1) init: 11 1 self) ; Adam, "I met Demeter, the Guardian of the Greens. I haven't found the Mayor yet, though."
			)
			(2
				(if (localproc_0 7 self)
					((ScriptID 2 0) init: 19 1 self) ; Delphineus, "Well, keep looking around the city. You'll find him."
				else
					((ScriptID 2 0) init: 11 1 self) ; Delphineus, "Well, you might try looking around in the Council Chambers."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance HNoShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "Have you found the Mayor or the Guardian of the Greens yet?"
			)
			(1
				((ScriptID 2 1) init: 12 1 self) ; Adam, "Yup. I found both the Mayor and the Guardian of the Greens."
			)
			(2
				((ScriptID 2 0) init: 21 1 self) ; Delphineus, "Good for you! What did the Mayor say?"
			)
			(3
				((ScriptID 2 1) init: 13 1 self) ; Adam, "Not much. I'm afraid he doesn't trust me because I'm a human boy."
			)
			(4
				((ScriptID 2 0) init: 22 1 self) ; Delphineus, "That's understandable, I guess, but not very fair. Maybe there's some way you can prove to the Mayor that you're a GOOD human."
			)
			(5
				((ScriptID 2 1) init: 14 1 self) ; Adam, "How?"
			)
			(6
				(if (localproc_0 8 self)
					((ScriptID 2 0) init: 23 1 self) ; Delphineus, "Does he have a problem? Maybe you can find something he really needs."
				else
					((ScriptID 2 0) init: 31 1 self) ; Delphineus, "I heard he was having a bit of a problem finding a new shell."
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance HDirtyShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 41 1 self) ; Delphineus, "Have you had any luck with the Mayor yet?"
			)
			(1
				((ScriptID 2 1) init: 19 1 self) ; Adam, "Not much. I'm afraid he doesn't trust me. I tried to give him a shell but he didn't like it because it's oily."
			)
			(2
				(if (localproc_0 9 self)
					((ScriptID 2 0) init: 32 1 self) ; Delphineus, "Did you try cleaning it?"
				else
					((ScriptID 2 0) init: 33 1 self) ; Delphineus, "Didn't I see a cotton cloth around here somewhere?"
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

