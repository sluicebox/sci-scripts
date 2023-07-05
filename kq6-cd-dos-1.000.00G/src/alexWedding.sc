;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 743)
(include sci.sh)
(use Main)
(use rm740)
(use n913)
(use Motion)
(use Actor)
(use System)

(public
	alexWedding 0
)

(local
	local0
	local1
)

(instance alexWedding of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(= register (>> (MemoryInfo 4) $0006)) ; TotalHunk
				(= local0 (== ((gInventory at: 25) owner:) gCurRoomNum)) ; newLamp
				(= ticks 30)
			)
			(1
				(gMessager say: 1 0 16 1 self 743) ; "Cassima and Alexander ask Captain Saladin to perform their wedding ceremony. Saladin is honored to do so."
			)
			(2
				(= ticks 60)
			)
			(3
				(gMessager say: 1 0 16 2 self 743) ; "On this historical day of great joy in the Land of the Green Isles, we witness the union of Cassima, beloved princess of this realm, and Alexander, prince of Daventry!"
			)
			(4
				(gCast eachElementDo: #dispose)
				(gTheIconBar
					enable:
					disable: 0 1 2 3 4 5 6
					height: -100
					activateHeight: -100
				)
				(Cursor showCursor: 0)
				(gCurRoom drawPic: 165 10)
				(= cycles 3)
			)
			(5
				(gMessager say: 1 0 7 0 self 165) ; "Do you, Prince Alexander of Daventry, take Princess Cassima to be your wife, to love and to cherish for as long as you both shall live?"
			)
			(6
				(cond
					((OneOf ((gInventory at: 39) owner:) 140 210) ; royalRing
						(= state 10)
						(gMessager say: 1 0 3 0 self 165) ; "Do you have a ring?"
					)
					((gEgo has: 39) ; royalRing
						(= state 10)
						(gMessager say: 1 0 4 0 self 165) ; "Do you have a ring?"
					)
					(else
						(gMessager say: 1 0 2 1 self 165) ; "Do you have a ring?"
					)
				)
			)
			(7
				(extraProp
					view: 165
					init:
					setLoop: 4
					cel: 0
					cycleSpeed: 4
					posn: 167 62
					setCycle: End self
				)
			)
			(8
				(= cycles 5)
			)
			(9
				((ScriptID 740 7) add: 165 1 0 2 2 add: 165 1 0 2 3 init: self) ; roomConv, "Er...I'm afraid I left my insignia ring in the pawn shop.", "That's all right, Alexander. We'll get one later."
			)
			(10
				(= state 12)
				(gMessager say: 1 0 2 4 self 165) ; "Well, hmmm, I guess we'll skip the ring."
			)
			(11
				(gCurRoom drawPic: 166 10)
				(extraProp
					view: 166
					init:
					setLoop: 0
					cel: 0
					cycleSpeed: 12
					posn: 82 127
				)
				(= seconds 3)
			)
			(12
				(extraProp setCycle: End self)
			)
			(13
				(extraProp dispose:)
				(proc740_10)
				(= cycles 3)
			)
			(14
				(gTheIconBar height: 0 activateHeight: 0)
				(Cursor showCursor: 1)
				(gTheIconBar enable:)
				(= cycles 2)
			)
			(15
				(UnLoad 128 7411)
				(if (not (IsFlag 15))
					(= state 18)
					(= ticks 30)
				else
					(gMessager say: 1 0 13 1 self 743) ; "Who gives this bride to be wed?"
				)
			)
			(16
				((ScriptID 740 11) ; caliphimallaria
					setLoop: 0
					cel: 0
					posn: 135 144
					cycleSpeed: 8
					setCycle: End
				)
				((ScriptID 740 1) setLoop: 2 cel: 0 cycleSpeed: 8 setCycle: End) ; priest
				(= seconds 3)
			)
			(17
				(gMessager say: 1 0 13 2 self 743) ; "Her mother and I willingly give our daughter's hand in wedlock."
			)
			(18
				(= state 24)
				((ScriptID 740 11) cel: 0) ; caliphimallaria
				(= ticks 60)
			)
			(19
				((ScriptID 740 11) setLoop: 2 cel: 0 posn: 128 147 stopUpd:) ; caliphimallaria
				(= cycles 2)
			)
			(20
				(gMessager say: 1 0 14 1 self 743) ; "Who gives this bride to be wed?"
			)
			(21
				((ScriptID 740 4) ; jollo
					view: 7465
					posn: (+ global164 32) (- global165 4)
					setCel: 255
					setLoop: 0
					scaleSignal: 1
					scaleX: 117
					scaleY: 117
					setCycle: Beg self
				)
			)
			(22
				((ScriptID 740 7) ; roomConv
					add: 743 1 0 14 2 ; "That would be me. In the name of King Caliphim, beloved friend, I give his daughter, Cassima, in wedlock."
					add: 743 1 0 14 3 ; "Thank you, Jollo."
					init: self
				)
			)
			(23
				((ScriptID 740 4) setCycle: End self) ; jollo
			)
			(24
				((ScriptID 740 4) ; jollo
					view: 746
					setLoop: 0
					cel: 0
					posn: global164 global165
					scaleSignal: 1
					scaleX: 115
					scaleY: 115
					stopUpd:
				)
				(= ticks 30)
			)
			(25
				(if local0
					(gMessager say: 1 0 12 1 self 743) ; "Who will speak for the groom?"
				else
					(= state 28)
					((ScriptID 740 1) setLoop: 0 cel: 0 cycleSpeed: 8) ; priest
					(= ticks 30)
				)
			)
			(26
				((ScriptID 740 12) setLoop: 2 cel: 0 setCycle: End self) ; grahamvalanice
			)
			(27
				(gMessager say: 1 0 12 2 self 743) ; "I will. Alexander's mother and I recognize his marriage to Princess Cassima with glad hearts and sanction this union."
			)
			(28
				(++ state)
				((ScriptID 740 12) setCycle: Beg self) ; grahamvalanice
			)
			(29
				((ScriptID 740 7) ; roomConv
					add: 743 1 0 11 1 ; "Since the groom has no family present, I will speak on his behalf."
					add: 743 1 0 11 2 ; "Alexander, your union with this woman is sanctioned and recognized in the eyes of the community."
					add: 743 1 0 11 3 ; "Thank you, Saladin."
					init: self
				)
			)
			(30
				(gMessager say: 1 0 15 1 self 743) ; "Then, Alexander and Cassima, I now pronounce you man and wife. You may kiss the bride."
			)
			(31
				((ScriptID 740 1) ; priest
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(if local0
					((ScriptID 740 12) ; grahamvalanice
						setLoop: 3
						cel: 0
						setCycle: End (ScriptID 740 12) ; grahamvalanice
					)
				)
				(if (IsFlag 15)
					((ScriptID 740 11) setLoop: 2 cel: 0 setCycle: Fwd) ; caliphimallaria
				)
				(gGlobalSound
					number: (if global169 1744 else 744)
					setLoop: -1
					play:
				)
			)
			(32
				(gMessager say: 1 0 15 2 self 743) ; "Hooray! Hooray! Hooray!"
			)
			(33
				(cond
					((not (IsFlag 10))
						((ScriptID 740 4) ; jollo
							view: 746
							setLoop: 0
							cel: 0
							setCycle: End self
						)
					)
					((and (not (IsFlag 15)) (not local0))
						((ScriptID 740 4) ; jollo
							view: 7461
							setLoop: 0
							cel: 0
							setCycle: End self
						)
					)
					(else
						((ScriptID 740 4) ; jollo
							view: 7463
							setLoop: 0
							cel: 0
							scaleSignal: 1
							scaleX: 115
							scaleY: 115
							setCycle: End self
						)
					)
				)
				((ScriptID 740 21) setCycle: End (ScriptID 740 21)) ; leftGuard, leftGuard
				((ScriptID 740 22) setCycle: End (ScriptID 740 22)) ; rightGuard, rightGuard
				((ScriptID 740 11) cel: 0 stopUpd:) ; caliphimallaria
			)
			(34
				(if (IsFlag 10)
					((ScriptID 740 4) ; jollo
						view: 746
						setLoop: 0
						cel: 0
						setCycle: 0
						scaleSignal: 1
						scaleX: 115
						scaleY: 115
					)
				)
				(= seconds 3)
			)
			(35
				((ScriptID 740 1) setCycle: Beg self) ; priest
			)
			(36
				(if (not (IsFlag 15))
					((ScriptID 740 1) setLoop: 0 cel: 0) ; priest
				else
					((ScriptID 740 1) setLoop: 2 setCycle: End) ; priest
				)
				((ScriptID 740 21) cue: 99) ; leftGuard
				((ScriptID 740 22) cue: 99) ; rightGuard
				(= seconds 3)
			)
			(37
				(if (IsFlag 15)
					((ScriptID 740 7) ; roomConv
						add: 743 1 0 6 1 ; "Congratulations, my children! I have an important question for you both, please hear me!"
						add: 743 1 0 6 2 ; "Yes, Sire?"
						add: 743 1 0 6 3 ; "Alexander, I welcome you into our family with open arms! I placed trust in Alhazred because I so badly wanted a son and a husband for my beloved daughter. I was wrong. But you are true and good, Alexander, and have proven yourself to all my people."
						add: 743 1 0 6 4 ; "Thank you, Sire."
						add: 743 1 0 6 5 ; "Allaria and I have been through much. Even though we have returned to our kingdom, I do not think we are able to reign again. Will you two consider the Crown? I know as king and queen you can heal this small kingdom from all the damage that Alhazred has inflicted upon it."
						add: 743 1 0 6 6 ; "Oh, Father!"
					)
				else
					((ScriptID 740 7) ; roomConv
						add: 743 1 0 7 1 ; "Excuse my interrupting your joy, but I have an important question for the new bride and groom."
						add: 743 1 0 7 2 ; "What is it, Saladin?"
						add: 743 1 0 7 3 ; "Alexander, Alhazred hurt this little kingdom nearly to the point of destroying all that we stand for. But you are true and good, and have proven yourself to all the people."
						add: 743 1 0 7 4 ; "Thank you, Captain."
						add: 743 1 0 7 5 ; "King Caliphim and Queen Allaria are gone and can never be restored. Alhazred has, thankfully, been banished. But we are leaderless. I believe you two can heal this small kingdom from all the damage that Alhazred has inflicted upon it."
						add: 743 1 0 7 6 ; "Will you two, Alexander and Cassima, consider becoming the ruling king and queen?"
					)
				)
				((ScriptID 740 7) init: self) ; roomConv
			)
			(38
				((ScriptID 740 7) add: 743 1 0 8 1 add: 743 1 0 8 3 init: self) ; roomConv, "Why, I'm honored.... What do you think, Cassima?", "I love my homeland, Alexander. I would be happy to stay and to serve it all my days."
			)
			(39
				(if local0
					(self setScript: hugStuff self)
				else
					((ScriptID 740 7) ; roomConv
						add: 743 1 0 10 1 ; "I wish my father were here so that I could ask his advice."
						add: 743 1 0 10 2 ; "I will miss him, and my mother and sister, and Daventry...."
						add: 743 1 0 10 3 ; "But I love you, Cassima, and I DO feel at home here. Somehow, this land and I seem to suit each other. I don't know what kind of a king I'll make, but...."
						add: 743 1 0 10 4 ; "I accept."
						init: self
					)
				)
			)
			(40
				(if (IsFlag 15)
					((ScriptID 740 7) add: 743 1 0 2 1 add: 743 1 0 2 2) ; roomConv, "Oh, Alexander, I am so glad! Between the return of my beloved parents and our new reign, you've made me so happy!", "I'm glad I could make up for some of your suffering, my beautiful wife."
				else
					((ScriptID 740 7) add: 743 1 0 1 1 add: 743 1 0 1 2) ; roomConv, "Oh, Alexander, I am so happy! If only my parents could have been alive to see this day, my joy would be complete!", "I'm sorry I could not spare you that grief, beloved."
				)
				((ScriptID 740 7) init: self) ; roomConv
			)
			(41
				(if local0
					(Portrait 2 {CASSIMA})
					((ScriptID 740 7) ; roomConv
						add: 743 1 0 19 1 ; "Congratulations, King Alexander! When we return home to Daventry, your crew will be glad to hear that their battle at sea was worthwhile--in bringing forth a new monarch!"
						add: 743 1 0 19 2 ; "We were so worried when your men arrived home without you, son! I'm so thankful that you are safe and happy!"
						add: 743 1 0 19 3 ; "And I am as grateful that my crew did not pay for my driven heart!"
						init: self
					)
					(Portrait 2 {VALANICE})
				else
					(= cycles 2)
				)
			)
			(42
				(if (== ((ScriptID 740 1) loop:) 2) ; priest
					((ScriptID 740 1) setCycle: Beg self) ; priest
				else
					(= cycles 2)
				)
			)
			(43
				((ScriptID 740 1) setLoop: 0 cel: 0) ; priest
				(= ticks 30)
			)
			(44
				(if local0
					(gMessager say: 1 0 5 1 self 743) ; "You have only brought us ALL good fortune, Sire! With Shamir saved, and his power used for good, reuniting the islands will be far easier. He has already repaired the ferry."
				else
					(gMessager say: 1 0 4 1 self 743) ; "King Alexander, there is a long road ahead. The ferry must be repaired before we can reunite the islands."
				)
			)
			(45
				(if ((ScriptID 80 0) tstFlag: #rFlag2 16) ; rgCastle
					(Portrait 2 {JOLLO})
					(Portrait 2 {VALANICE})
					(Portrait 0 {CASSIMA})
					(Portrait 0 {SALADIN})
					((ScriptID 740 7) ; roomConv
						add: 743 1 0 17 1 ; "Your road will be easier now that the islands are no longer feuding. Already the wounds are starting to heal."
						add: 743 1 0 17 2 ; "Yes, my love, discovering the island's stolen treasures has done more to bring peace to this land than anything else. It is now clear that Alhazred had Shamir steal each of the island's most valued treasure, then blamed the thefts on others to cause the islands to hate each other."
						init: self
					)
				else
					((ScriptID 740 7) ; roomConv
						add: 743 1 0 18 1 ; "Unfortunately, the islands are still feuding. It will take some time, and great diplomacy, to convince them to reunite and stop fighting each other."
						add: 743 1 0 18 2 ; "Yes, Alexander. We will have to try to discover how Alhazred managed to make them hate each other so that we can undo what he has done."
						init: self
					)
				)
			)
			(46
				(gMessager say: 1 0 3 1 self 743) ; "Now, let us celebrate our good fortune! The evil that has plagued this land is done, and a new reign begins! Long live King Alexander and Queen Cassima!"
			)
			(47
				((ScriptID 740 1) setLoop: 2 cel: 0 setCycle: End self) ; priest
			)
			(48
				(gNarrator keepWindow: 1 modeless: 0)
				(gMessager say: 1 0 3 2 self 743) ; "LONG LIVE KING ALEXANDER!"
			)
			(49
				(DisposeScript 1001)
				(DisposeScript 1005)
				(DisposeScript 1026)
				(DisposeScript 1004)
				(if (and local0 ((ScriptID 80 0) tstFlag: #rFlag2 16)) ; rgCastle
					((ScriptID 740 16) setCycle: Fwd) ; redQueen
					((ScriptID 740 17) setCycle: Fwd) ; whiteQueen
					((ScriptID 740 19) view: 7472 setLoop: 1 setCycle: Fwd) ; druid2
					((ScriptID 740 18) view: 7472 setLoop: 0 setCycle: Fwd) ; druid1
					((ScriptID 740 20) view: 7472 setLoop: 2 setCycle: Fwd) ; druid3
					(clap1 init: setCycle: Fwd)
					(clap2 init: setCycle: Fwd)
					((ScriptID 740 14) ; prince
						view: 7471
						setLoop: 2
						cel: 0
						posn: 236 189
						setPri: 15
						setCycle: End (ScriptID 740 14) ; prince
					)
					((ScriptID 740 15) ; beauty
						view: 7471
						setLoop: 3
						cel: 0
						posn: 248 186
						setPri: 14
						setCycle: End (ScriptID 740 15) ; beauty
					)
				)
				(cond
					((not (IsFlag 10))
						((ScriptID 740 4) ; jollo
							view: 746
							setLoop: 0
							cel: 0
							setCycle: End
						)
					)
					((not (IsFlag 15))
						((ScriptID 740 4) setScript: clap 0 0) ; jollo
					)
					((not (gCast contains: (ScriptID 740 3))) ; genie
						((ScriptID 740 4) setScript: clap 0 1) ; jollo
					)
					(else
						((ScriptID 740 4) ; jollo
							view: 7460
							setLoop: 0
							scaleSignal: 1
							scaleX: 115
							scaleY: 115
							setCycle: Fwd
						)
					)
				)
				(if (IsFlag 15)
					((ScriptID 740 11) ; caliphimallaria
						setLoop: 2
						setCycle: End (ScriptID 740 11) ; caliphimallaria
					)
				)
				((ScriptID 740 21) setCycle: End (ScriptID 740 21)) ; leftGuard, leftGuard
				((ScriptID 740 22) setCycle: End (ScriptID 740 22)) ; rightGuard, rightGuard
				(if (== ((gInventory at: 25) owner:) 740) ; newLamp
					(self setScript: (ScriptID 752 2) self (ScriptID 740 3)) ; geniePoofOut, genie
				else
					(= state 51)
					(= cycles 2)
				)
			)
			(50
				((ScriptID 740 3) posn: 195 152) ; genie
				(self setScript: (ScriptID 752 1) self (ScriptID 740 3)) ; geniePoofIn, genie
			)
			(51
				((ScriptID 740 3) view: 7481 setLoop: 0 cel: 0) ; genie
				(= ticks 30)
			)
			(52
				(gNarrator keepWindow: 1 modeless: 0)
				((ScriptID 740 7) ; roomConv
					add: 743 1 0 3 3 ; "LONG LIVE QUEEN CASSIMA!"
					add: 743 1 0 3 4 ; "LONG LIVE THE LAND OF THE GREEN ISLES!"
					add: 743 1 0 3 5 ; "Hooray! Hooray! Hooray!"
					init: self
				)
			)
			(53
				(if (== ((gInventory at: 25) owner:) 740) ; newLamp
					(= cycles 2)
				else
					((ScriptID 740 1) setLoop: 1 cel: 0 setCycle: End) ; priest
				)
				(gGlobalSound number: 747 setLoop: 1 play: gCurRoom)
			)
			(54
				((ScriptID 740 3) cycleSpeed: 10 setCycle: End self) ; genie
			)
			(55
				((ScriptID 740 1) ; priest
					view: 7481
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				((ScriptID 740 3) cel: 0) ; genie
			)
			(56
				((ScriptID 740 3) setCycle: End self) ; genie
			)
			(57
				((ScriptID 740 1) setLoop: 2 cel: 0 setCycle: End) ; priest
				((ScriptID 740 3) view: 7020 setLoop: 0 cel: 0 stopUpd:) ; genie
			)
		)
	)
)

(instance hugStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= ((ScriptID 740 1) loop:) 2) ; priest
					((ScriptID 740 1) setLoop: 2 cel: 0 setCycle: End self) ; priest
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 1 0 9 1 self 743) ; "Father? I believe I am needed here. Would you be very disappointed if...."
			)
			(3
				((ScriptID 740 12) ; grahamvalanice
					view: 7451
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gMessager say: 1 0 9 2 self 743) ; "Son, you must follow your destiny. I DO believe the Land of the Green Isles needs you. You will be a magnificent king, though dearly missed in Daventry."
			)
			(5
				((ScriptID 740 1) hide:) ; priest
				((ScriptID 740 12) ; grahamvalanice
					setLoop: 1
					cel: 0
					posn: 221 145
					setCycle: End self
				)
			)
			(6
				(gMessager say: 1 0 9 3 self 743) ; "Then, I accept."
			)
			(7
				((ScriptID 740 12) setLoop: 2 cel: 0 setCycle: End self) ; grahamvalanice
			)
			(8
				(Portrait 2 {CASSIMA})
				(gMessager say: 1 0 9 4 self 743) ; "Oh, my boy! What a man you've become, and how I will miss you!"
				(Portrait 2 {VALANICE})
			)
			(9
				((ScriptID 740 1) show:) ; priest
				((ScriptID 740 12) ; grahamvalanice
					setLoop: 0
					setCel: 255
					posn: 216 144
					cycleSpeed: 10
					setCycle: Beg self
				)
			)
			(10
				(gMessager say: 1 0 9 5 self 743) ; "Don't worry, Mother. With Shamir's powers we'll be able to visit often! I'm not about to forget my family."
			)
			(11
				((ScriptID 740 12) addToPic:) ; grahamvalanice
				(DisposeScript 1065)
				(DisposeScript 1066)
				(= cycles 2)
			)
			(12
				((ScriptID 740 1) setPri: 8) ; priest
				((ScriptID 740 13) ; rosella
					view: 7452
					setPri: 9
					setLoop: 0
					cel: 0
					posn: 228 145
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(13
				((ScriptID 740 1) hide:) ; priest
				((ScriptID 740 13) ; rosella
					setLoop: 1
					cel: 0
					posn: 178 139
					setCycle: End self
				)
			)
			(14
				(gMessager say: 1 0 9 6 self 743) ; "Congratulations, Alexander! I'm so proud of you!"
			)
			(15
				(gMessager say: 1 0 9 7 self 743) ; "Thank you, dear sister."
			)
			(16
				((ScriptID 740 1) show: setPri: -1) ; priest
				((ScriptID 740 13) ; rosella
					setLoop: 2
					cel: 0
					posn: 227 146
					setCycle: End self
				)
			)
			(17
				((ScriptID 740 13) ; rosella
					view: 745
					setLoop: 4
					cel: 2
					posn: 235 145
					signal: 26624
				)
				(= ticks 30)
			)
			(18
				((ScriptID 740 13) addToPic:) ; rosella
				(DisposeScript 1067)
				(= cycles 2)
			)
			(19
				(self dispose:)
			)
		)
	)
)

(instance extraProp of Prop
	(properties
		view 165
		loop 4
		signal 26624
		detailLevel 2
	)
)

(instance clap1 of Prop
	(properties
		x 30
		y 145
		view 7471
		loop 5
		priority 15
		signal 18448
		cycleSpeed 4
		detailLevel 2
	)
)

(instance clap2 of Prop
	(properties
		x 54
		y 141
		view 7471
		loop 6
		priority 15
		signal 18448
		cycleSpeed 4
		detailLevel 2
	)
)

(instance clap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 740 4) ; jollo
					view: 7462
					setLoop: 0
					cel: 0
					scaleSignal: 1
					scaleX: 105
					scaleY: 105
					setCycle: End self
				)
			)
			(1
				((ScriptID 740 4) setLoop: 1 setCycle: Fwd) ; jollo
				(if register
					(= seconds 3)
				)
			)
			(2
				((ScriptID 740 4) setLoop: 0 setCel: 255 setCycle: Beg self) ; jollo
			)
			(3
				((ScriptID 740 4) ; jollo
					view: 7463
					cel: 0
					setLoop: 0
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(self init:)
			)
		)
	)
)

